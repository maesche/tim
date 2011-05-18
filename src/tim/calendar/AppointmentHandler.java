package tim.calendar;

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

	public ArrayList<Appointment> getElements() {

		ArrayList<Appointment> appointments = new ArrayList<Appointment>();

		String sql = "SELECT" +
					 "	A.appointment_id AS A_id, " +
					 "	A.title, " +
					 "	A.description, " +
					 "  DATE_FORMAT(D.begin, '%Y-%m-%d %H:%i:%s') AS begin, " +
					 "  DATE_FORMAT(D.end, '%Y-%m-%d %H:%i:%s') AS end, " +
					 "  DATE_FORMAT(D.end, '%H:%i') AS test, " +
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
                     "	ON A.employee_id = E.employee_id " +
					 "ORDER BY begin";

		Connection conn;
		Statement stmt;
		ResultSet rs;
		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				long id = rs.getLong("A_id");
				
				System.out.println(rs.getTime("test"));

				/*Date begin = DateHelper.StringToDate(rs.getString("begin"));
				Date end = DateHelper.StringToDate(rs.getString("end"));*/
				Date begin = rs.getDate("begin");
				Date end = rs.getDate("end");
				String title = rs.getString("title");
				String description = rs.getString("description");
	
				Employee employee = new Employee(rs.getInt("E_id"), rs.getString("E_firstName"), rs.getString("E_lastName"));
				Client client = new Client(rs.getInt("C_id"), rs.getString("C_firstName"), rs.getString("C_lastName"));

				Appointment appointment = new Appointment(id, begin, end, title, description, employee, client);

				appointments.add(appointment);
			}
		} catch (SQLException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "getElements");
		}
		finally {
			Db.close();
		}
		return appointments;
	}

	public void delete(Appointment appointment) {
		// TODO Auto-generated method stub

	}

	public void add(Appointment appointment) {
		long id = new Date().getTime();
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
		
		System.out.println(sql_appointment);
		System.out.println(sql_dates);
		
		/*Connection conn;
		Statement stmt;

		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql_appointment);
			stmt.executeUpdate(sql_dates);
		
		} catch (SQLException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "add");
		}
		finally {
			Db.close();
		}*/

	}

	public void update(Appointment appointment) {
		// TODO Auto-generated method stub

	}

}
