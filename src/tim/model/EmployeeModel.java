package tim.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Db;
import tim.application.ErrorHandler;

public class EmployeeModel extends PersonModel {
	public ArrayList<Element> get(long fId) {

		Connection conn;
		Statement stmt = null;
		ResultSet rs;

		ArrayList<String> filter = new ArrayList<String>();

		ArrayList<Element> employees = new ArrayList<Element>();

		String sql = "SELECT" + 
				"	employee_id, " 
				+ "	A.title, "
				+ "	A.description, " 
				+ "  D.begin, " 
				+ "  D.end, "
				+ "	C.client_id AS C_id, "
				+ "	C.firstName AS C_firstName, "
				+ "	C.lastName AS C_lastName, " 
				+ "	E.employee_id AS E_id, "
				+ "	E.firstName AS E_firstName, "
				+ "	E.lastName AS E_lastName " + "FROM employees";

		if (fId > 0) {
			filter.add("A.appointment_id=" + fId);
		}

		for (int i = 0; i < filter.size(); i++) {
			if (i > 0) {
				sql += "AND";
			} else {
				sql += " WHERE";
			}
			sql += " " + filter.get(i);
		}

		sql += " ORDER BY begin";

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

				Person employee = new Employee(rs.getInt("E_id"),
						rs.getString("E_firstName"), rs.getString("E_lastName"));
				Person client = new Client(rs.getInt("C_id"),
						rs.getString("C_firstName"), rs.getString("C_lastName"));

				Appointment appointment = new Appointment(id, begin, end,
						title, description, employee, client);

				employees.add(appointment);
			}
			stmt.close();
		} catch (Exception ex) {
			ErrorHandler.getException(ex, this.getClass().getName(),
					"getElements");
		} finally {

			Db.close();
		}
		return employees;
	}

	@Override
	public void add(Element element) throws ClassCastException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Element element) throws ClassCastException {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Element element) throws ClassCastException {
		// TODO Auto-generated method stub

	}

}
