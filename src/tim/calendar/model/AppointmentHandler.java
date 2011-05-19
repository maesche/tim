package tim.calendar.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Db;
import tim.application.ErrorHandler;
import tim.application.DateHelper;

public class AppointmentHandler {

	public ArrayList<Appointment> getElements(Client fClient, Employee fEmployee, Date fSince, Date fUntil, long fId) {
		Connection conn;
		Statement stmt = null;
		ResultSet rs;
		
		ArrayList<String> filter = new ArrayList<String>();
		
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();

		String sql = "SELECT" +
					 "	A.appointment_id AS A_id, " +
					 "	A.title, " +
					 "	A.description, " +
					 "  D.begin, " +
					 "  D.end, " +
					 "	C.client_id AS C_id, " +
					 "	C.firstName AS C_firstName, " +
					 "	C.lastName AS C_lastName, " +
					 "	E.employee_id AS E_id, " +
					 "	E.firstName AS E_firstName, " +
					 "	E.lastName AS E_lastName " +
					 "FROM appointments A " +
                     "LEFT OUTER JOIN appointment_dates D " +
                     "  ON A.appointment_id = D.appointment_id " +
                     "LEFT JOIN clients C " +
                     "	ON A.client_id = C.client_id " +
                     "LEFT JOIN employees E" +
                     "	ON A.employee_id = E.employee_id";
		
		if (fId > 0) {
			filter.add("A.appointment_id=" + fId);
		}

		if (fSince != null) {
			filter.add("begin >= '" + DateHelper.DateToString(fSince) + "'");
			
			if (fUntil != null) {
				filter.add("end <= '" + DateHelper.DateToString(fUntil) + "'");
			}
		}
		
		if (fClient != null) {
			filter.add("A.client_id = " + fClient.getId());
		}
		
		if (fEmployee != null) {
			filter.add("A.employee = " + fEmployee.getId());
		}
		
		for (int i = 0; i < filter.size(); i++) {
			if (i > 0) {
				sql += "AND";
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
			
			while (rs.next()) {
				long id = rs.getLong("A_id");
				
				Date begin = rs.getTimestamp("begin");
				Date end = rs.getTimestamp("end");
				String title = rs.getString("title");
				String description = rs.getString("description");
	
				Employee employee = new Employee(rs.getInt("E_id"), rs.getString("E_firstName"), rs.getString("E_lastName"));
				Client client = new Client(rs.getInt("C_id"), rs.getString("C_firstName"), rs.getString("C_lastName"));

				Appointment appointment = new Appointment(id, begin, end, title, description, employee, client);
				
				appointments.add(appointment);
			}
			stmt.close();
		} catch (Exception ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "getElements");
		}
		finally {
	
			Db.close();
		}
		return appointments;
	}
	
	public ArrayList<Appointment> getElements() {
		return this.getElements(null, null, null, null, 0);
	}
	
	public ArrayList<Appointment> getElements(long id) {
		return this.getElements(null, null, null, null, id);
	}
	
	public ArrayList<Appointment> getElements(Date begin) {
		return this.getElements(null, null, begin, null, 0);
	}
	
	public ArrayList<Appointment> getElements(Date begin, Date end) {
		return this.getElements(null, null, begin, end, 0);
	}
	
	public ArrayList<Appointment> getElements(Client client) {
		return this.getElements(client, null, null, null, 0);
	}

	public ArrayList<Appointment> getElements(Client client, Date begin) {
		return this.getElements(client, null, begin, null, 0);
	}
	
	public ArrayList<Appointment> getElements(Client client, Date begin, Date end) {
		return this.getElements(client, null, begin, end, 0);
	}
	
	public ArrayList<Appointment> getElements(Employee employee) {
		return this.getElements(null, employee, null, null, 0);
	}
	
	public ArrayList<Appointment> getElements(Employee employee, Date begin) {
		return this.getElements(null, employee, begin, null, 0);
	}
	
	public ArrayList<Appointment> getElements(Employee employee, Date begin, Date end) {
		return this.getElements(null, employee, begin, null, 0);
	}
	
	public ArrayList<Appointment> getElements(Client client, Employee employee) {
		return this.getElements(client, employee, null, null, 0);
	}
	
	public ArrayList<Appointment> getElements(Client client, Employee employee, Date begin) {
		return this.getElements(client, employee, begin, null, 0);
	}

	public void add(Appointment appointment) {
		long id = appointment.getId();
		int client_id = appointment.getClient().getId();
		int employee_id = appointment.getEmployee().getId();
		String title = appointment.getTitle();
		String description = appointment.getDescription();
		
		String begin = DateHelper.DateToString(appointment.getBegin());
		String end = DateHelper.DateToString(appointment.getEnd());
		
		String sql_appointment = "INSERT INTO appointments VALUES(" +
				id + ", " +
				client_id + ", " +
				employee_id + ", " +
				"'" + title + "', " +
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
		} catch (SQLException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "add");
		}
		finally {
			Db.close();
		}

	}

	public void update(Appointment appointment) {
		// TODO Auto-generated method stub

	}
	public void delete(Appointment appointment) {
		// TODO Auto-generated method stub

	}
}
