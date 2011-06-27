package tim.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import tim.application.Config;
import tim.application.Db;
import tim.application.GlobalRegistry;
import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.CurrentClassGetter;
import tim.application.utils.DateHelper;
import tim.application.utils.ErrorHandler;

public class AppointmentModel extends AbstractModel{

	public ArrayList<Element> get(Client fClient, Employee fEmployee, Date fSince, Date fUntil, long fId) throws PersistanceException {
		Connection conn;
		Statement stmt = null;
		ResultSet rs;
		
		ArrayList<String> filter = new ArrayList<String>();
		
		ArrayList<Element> appointments = new ArrayList<Element>();

		String sql = "SELECT" +
					 "	A.appointment_id AS A_id, " +
					 "	A.description, " +
					 "  D.begin, " +
					 "  D.end, " +
					 "	A.client_id AS C_id, " +
					 "	A.employee_id AS E_id " +
					 "FROM appointments A " +
                     "LEFT OUTER JOIN appointment_dates D " +
                     "  ON A.appointment_id = D.appointment_id ";
		
		if (fId > 0) {
			filter.add("A.appointment_id=" + fId);
		}

		if (fSince != null) {
			filter.add("begin >= '" + DateHelper.DateToString(fSince, Config.DATE_FORMAT_LONG) + "'");
			
			if (fUntil != null) {
				filter.add("end <= '" + DateHelper.DateToString(fUntil, Config.DATE_FORMAT_LONG) + "'");
			}
		}
		
		if (fClient != null) {
			filter.add("A.client_id = " + fClient.getId());
		}
		
		if (fEmployee != null) {
			filter.add("A.employee_id = " + fEmployee.getId());
		}
		
		for (int i = 0; i < filter.size(); i++) {
			if (i > 0) {
				sql += " AND";
			}else {
				sql += " WHERE";
			}
			sql += " " + filter.get(i);
		}
		
		sql +=  " ORDER BY begin";

		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			EmployeeModel employeeModel = (EmployeeModel) GlobalRegistry.mvcLinker.getModels().get("EmployeeModel");
			ClientModel clientModel = (ClientModel) GlobalRegistry.mvcLinker.getModels().get("ClientModel");
			
			while (rs.next()) {
				
				long id = rs.getLong("A_id");
				
				Date begin = rs.getTimestamp("begin");
				Date end = rs.getTimestamp("end");
				String description = rs.getString("description");
	
				Person employee = (Employee) employeeModel.get(rs.getInt("E_id")).get(0);
				Person client = (Client) clientModel.get(rs.getInt("C_id")).get(0);

				Appointment appointment = new Appointment(id, begin, end, description, employee, client);
				
				appointments.add(appointment);
			}
			stmt.close();
		} catch (Exception ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "getElements"));
		}
		finally {
			Db.close();
		}
		return appointments;
	}
	
	public ArrayList<Element> get() throws PersistanceException {
		return this.get(null, null, null, null, 0);
	}
	
	public ArrayList<Element> get(long id) throws PersistanceException {
		return this.get(null, null, null, null, id);
	}
	
	public ArrayList<Element> get(Date begin) throws PersistanceException {
		return this.get(null, null, begin, null, 0);
	}
	
	public ArrayList<Element> get(Date begin, Date end) throws PersistanceException {
		return this.get(null, null, begin, end, 0);
	}
	
	public ArrayList<Element> get(Client client) throws PersistanceException {
		return this.get(client, null, null, null, 0);
	}

	public ArrayList<Element> get(Client client, Date begin) throws PersistanceException {
		return this.get(client, null, begin, null, 0);
	}
	
	public ArrayList<Element> get(Client client, Date begin, Date end) throws PersistanceException {
		return this.get(client, null, begin, end, 0);
	}
	
	public ArrayList<Element> get(Employee employee) throws PersistanceException {
		return this.get(null, employee, null, null, 0);
	}
	
	public ArrayList<Element> get(Employee employee, Date begin) throws PersistanceException {
		return this.get(null, employee, begin, null, 0);
	}
	
	public ArrayList<Element> get(Employee employee, Date begin, Date end) throws PersistanceException {
		return this.get(null, employee, begin, end, 0);
	}
	
	public ArrayList<Element> get(Client client, Employee employee) throws PersistanceException {
		return this.get(client, employee, null, null, 0);
	}
	
	public ArrayList<Element> get(Client client, Employee employee, Date begin) throws PersistanceException {
		return this.get(client, employee, begin, null, 0);
	}

	public void add(Element element) throws PersistanceException {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		long id = cal.getTimeInMillis();;
		long client_id = 0;
		long employee_id = 0;
		String description = null;
		String begin = null;
		String end = null;
		
		Appointment appointment = (Appointment) element;
		client_id = appointment.getClient().getId();
		employee_id = appointment.getEmployee().getId();
		description = appointment.getDescription();
		
		begin = DateHelper.DateToString(appointment.getBegin(), Config.DATE_FORMAT_LONG);
		end = DateHelper.DateToString(appointment.getEnd(), Config.DATE_FORMAT_LONG);
		
		String sql_appointment = "INSERT INTO appointments VALUES(" +
				id + ", " +
				client_id + ", " +
				employee_id + ", " +
				"'" + description + "')";
		
		String sql_dates = "INSERT INTO appointment_dates (appointment_id, begin, end) VALUES(" +
				id + ", " +
				"'" + begin + "', " +
				"'" + end + "')";

		Connection conn;
		Statement stmt;

		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql_appointment);
			stmt.executeUpdate(sql_dates);
			stmt.close();
			setChanged();
			notifyObservers(element);
		} catch (SQLException ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "add"));
		}
		finally {
			Db.close();
		}
	}

	public void edit(Element element) {
		// TODO Auto-generated method stub

	}
	public void remove(Element element) throws PersistanceException {
		Connection conn;
		Statement stmt;

		String sql;
		
		long id = element.getId();
		
		
		sql = "DELETE FROM appointments WHERE appointment_id=" + id;


		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			setChanged();
			notifyObservers(element);
		} catch (SQLException ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "delete"));
		}
		finally {
			Db.close();
		}

	}
}
