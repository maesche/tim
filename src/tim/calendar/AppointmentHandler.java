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
					 "ORDER BY A.appointment_id";

		Statement stmt;
		ResultSet rs;
		try {
			Connection conn = Db.open();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("A_id");

				Date begin = DateHelper.StringToDate(rs.getString("begin"));
				Date end = DateHelper.StringToDate(rs.getString("end"));
				String title = rs.getString("title");
				String description = rs.getString("description");
	
				Employee employee = new Employee(rs.getInt("E_id"), rs.getString("E_firstName"), rs.getString("E_lastName"), null, null, null);
				

				Client client = new Client(rs.getInt("C_id"), rs.getString("C_firstName"), rs.getString("C_lastName"), null, null, null);

				Appointment appointment = new Appointment(id, begin, end, title, description, employee, client);

				appointments.add(appointment);
			}
		} catch (SQLException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "getElements");
		}
		return appointments;
	}

	public void delete(Appointment appointment) {
		// TODO Auto-generated method stub

	}

	public void add(Appointment appointment) {
		// TODO Auto-generated method stub

	}

	public void update(Appointment appointment) {
		// TODO Auto-generated method stub

	}

}
