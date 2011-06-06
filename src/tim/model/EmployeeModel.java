package tim.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Db;
import tim.application.utils.ErrorHandler;

public class EmployeeModel extends PersonModel {
	public ArrayList<Element> get(long fId) {

		Connection conn;
		Statement stmt = null;
		ResultSet rs;

		ArrayList<String> filter = new ArrayList<String>();

		ArrayList<Element> employees = new ArrayList<Element>();

		String sql = "SELECT" + 
		"	employee_id, " 
		+ "	firstName, "
		+ "	lastName " + "FROM employees";

		if (fId > 0) {
			filter.add("employee_id=" + fId);
		}

		for (int i = 0; i < filter.size(); i++) {
			if (i > 0) {
				sql += "AND";
			} else {
				sql += " WHERE";
			}
			sql += " " + filter.get(i);
		}

		sql += " ORDER BY employee_id";

		try {
			conn = Db.open();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Person employee = new Employee(rs.getInt("employee_id"),
						rs.getString("firstName"), rs.getString("lastName"));

				employees.add(employee);
			}
			stmt.close();
		} catch (Exception ex) {
			ErrorHandler.getException(ex, this.getClass().getName(),
					"get");
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
