package tim.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tim.application.Db;
import tim.application.ErrorHandler;

public class AppointmentHandler {

	public ArrayList<Appointment> getElements() {

		ArrayList<Appointment> appointments = new ArrayList<Appointment>();

		String sql = "SELECT" +
					 "	A.appointment_id" +
					 "FROM appointments A" +
					 "ORDER BY A.appointment_id";

		Statement stmt;
		ResultSet rs;
		try {
			stmt = Db.open().createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String s = rs.getString("appointment_id");
				System.out.println(s);
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
