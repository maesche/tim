package tim.calendar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import tim.application.Db;
import tim.application.ErrorHandler;

public class AppointmentHandler {

	public ArrayList<Appointment> getElements() {

		ArrayList<Appointment> appointments = new ArrayList<Appointment>();

		String sql = "SELECT" +
					 "	A.appointment_id AS id, " +
					 "  DATE_FORMAT(D.begin, '%Y-%m-%d %H:%i:%s') AS begin, " +
					 "  DATE_FORMAT(D.end, '%Y-%m-%d %H:%i:%s') AS end " +
					 "FROM appointments A " +
                     "LEFT OUTER JOIN appointment_dates D " +
                     "    ON A.appointment_id = D.appointment_id " +
					 "ORDER BY A.appointment_id";

		Statement stmt;
		ResultSet rs;
		try {
			Connection conn = Db.open();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				df.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));
				Date begin = null;
				try {
					begin = df.parse((String)rs.getString("begin"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date end = null;
				try {
					end = df.parse((String)rs.getString("end"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				Employee employee = null;
				Client client = null;
				String title = null;
				String description = null;
				
				Appointment appointment = new Appointment(id, begin, end, title, description, employee, client);

				appointments.add(appointment);
			}
		} catch (SQLException ex) {
			ErrorHandler.getException(ex);
		}
		return appointments;
	}

	public void delete(Appointment appointment) {
		// TODO Auto-generated method stub

	}

	public void add() {
		// TODO Auto-generated method stub

	}

	public void update() {
		// TODO Auto-generated method stub

	}

}
