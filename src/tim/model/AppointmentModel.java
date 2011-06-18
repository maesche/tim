package tim.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Db;
import tim.application.utils.DateHelper;
import tim.application.utils.ErrorHandler;

public class AppointmentModel extends AbstractModel{

	public ArrayList<Element> get(Client fClient, Employee fEmployee, Date fSince, Date fUntil, long fId) {
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
			filter.add("begin >= '" + DateHelper.DateToString(fSince) + "'");
			
			if (fUntil != null) {
				filter.add("end <= '" + DateHelper.DateToString(fUntil) + "'");
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
			
			EmployeeModel employeeModel = new EmployeeModel();
			ClientModel clientModel = new ClientModel();
			
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
			ErrorHandler.getException(ex, this.getClass().getName(), "getElements");
		}
		finally {
			Db.close();
		}
		return appointments;
	}
	
	public ArrayList<Element> get() {
		return this.get(null, null, null, null, 0);
	}
	
	public ArrayList<Element> get(long id) {
		return this.get(null, null, null, null, id);
	}
	
	public ArrayList<Element> get(Date begin) {
		return this.get(null, null, begin, null, 0);
	}
	
	public ArrayList<Element> get(Date begin, Date end) {
		return this.get(null, null, begin, end, 0);
	}
	
	public ArrayList<Element> get(Client client) {
		return this.get(client, null, null, null, 0);
	}

	public ArrayList<Element> get(Client client, Date begin) {
		return this.get(client, null, begin, null, 0);
	}
	
	public ArrayList<Element> get(Client client, Date begin, Date end) {
		return this.get(client, null, begin, end, 0);
	}
	
	public ArrayList<Element> get(Employee employee) {
		return this.get(null, employee, null, null, 0);
	}
	
	public ArrayList<Element> get(Employee employee, Date begin) {
		return this.get(null, employee, begin, null, 0);
	}
	
	public ArrayList<Element> get(Employee employee, Date begin, Date end) {
		return this.get(null, employee, begin, end, 0);
	}
	
	public ArrayList<Element> get(Client client, Employee employee) {
		return this.get(client, employee, null, null, 0);
	}
	
	public ArrayList<Element> get(Client client, Employee employee, Date begin) {
		return this.get(client, employee, begin, null, 0);
	}

	//public void add(ArrayList<Element> elements
	public void add(Element element) {
		
		long id = 0;
		long client_id = 0;
		long employee_id = 0;
		String description = null;
		String begin = null;
		String end = null;
		
		Appointment appointment =
			
			
			(Appointment) element;
		id = appointment.getId();
		client_id = appointment.getClient().getId();
		employee_id = appointment.getEmployee().getId();
		description = appointment.getDescription();
		
		begin = DateHelper.DateToString(appointment.getBegin());
		end = DateHelper.DateToString(appointment.getEnd());
		
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
		} catch (SQLException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "add");
		}
		finally {
			Db.close();
		}

	}

	public void edit(Element element) {
		// TODO Auto-generated method stub

	}
	public void remove(Element element) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkAvailability(Appointment appointment) {
		/*
		 *  $nbEvents = 0;
        $canInsert = true;


        for ($i = 0; $i < count($currentEvents) && $canInsert; $i++) {
            $start = strtotime($currentEvents[$i]['start']);
            $end = strtotime($currentEvents[$i]['end']);
            $id = $currentEvents[$i]['id'];

            $e_start = strtotime($newEvent['start']);
            $e_end = strtotime($newEvent['end']);
            $e_id = $newEvent['id'];

            $canInsert = ($e_end <= $start || $e_start >= $end);


//if (!$canInsert && $id != $e_id) {
            if (!$canInsert) {
                $nbEvents++;
                $canInsert = $nbEvents < $maxEvents;
            }
        }


        return $canInsert;
		 */
		boolean canInsert = true;

		Date begin = appointment.getBegin();
	//	Date end = DateHelper.StringToDate(DateHelper.DateToString(appointment.getEnd(), Config.DATE_FORMAT_SHORT));
		
		ArrayList<Element> appointments = this.get(appointment.getBegin(), appointment.getEnd());
		
		for (Element element : appointments) {
			Appointment app = (Appointment) element;
			
		}
		
		return true;
	}
}