package tim.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Db;
import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.application.utils.ErrorHandler;

public class ClientModel extends PersonModel {

	@Override
	public ArrayList<Element> get(long fId) throws PersistanceException {
		Connection conn;
		Statement stmt = null;
		ResultSet rs;

		ArrayList<String> filter = new ArrayList<String>();

		ArrayList<Element> clients = new ArrayList<Element>();

		String sql = "SELECT" + 
				"	client_id, " 
				+ "	firstName, "
				+ "	lastName, " 
				+ "	phone, "
				+ "	address, "
				+ "	description " + "FROM clients";

		if (fId > 0) {
			filter.add("client_id=" + fId);
		}

		for (int i = 0; i < filter.size(); i++) {
			if (i > 0) {
				sql += "AND";
			} else {
				sql += " WHERE";
			}
			sql += " " + filter.get(i);
		}

		sql += " ORDER BY client_id";

		try {
			conn = Db.open();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				Person client = new Client(rs.getInt("client_id"),
						rs.getString("firstName"), rs.getString("lastName"));


				clients.add(client);
			}
			stmt.close();
		} catch (Exception ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "getElements"));
		} finally {

			Db.close();
		}
		return clients;
	}

	@Override
	public void add(Element element) throws ClassCastException, PersistanceException {
		Connection conn;
		Statement stmt;
		Client client = (Client) element;
		String sql;
		

		
		String firstName = null;
		String lastName = null;
		String phone = null;
		String address = null;
		String comment = null;
		
		firstName = client.getFirstName();
		lastName = client.getLastName();
		phone = client.getPhone();
		address = client.getAddress();
		comment = client.getComment();
		

		sql = "INSERT INTO clients (firstName, lastName, phone, address, description) VALUES(" 
				+ "'" + firstName + "', "
				+ "'" + lastName + "', "
				+ "'" + phone + "', "
				+ "'" + address + "', "
				+ "'" + comment + "'"
				+		")";
		

		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			setChanged();
			notifyObservers();
		} catch (SQLException ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "add"));
		}
		finally {
			Db.close();
		}
	}

	@Override
	public void remove(Element element) throws ClassCastException, PersistanceException {
		Connection conn;
		Statement stmt;

		String sql;
		
		long id = element.getId();
		
		
		sql = "DELETE FROM clients WHERE client_id=" + id;

		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "delete"));
		}
		finally {
			Db.close();
		}
	}

	@Override
	public void edit(Element element) throws ClassCastException {
		// TODO Auto-generated method stub

	}

}
