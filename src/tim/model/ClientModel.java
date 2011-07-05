package tim.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tim.application.Db;
import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.SQLQueryHelper;

/**
 * This models is a DAO for Client objects and interacts whith the database
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class ClientModel extends PersonModel {

	@Override
	/**
	 * {@inheritDoc}
	 */
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
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getString("address"), rs.getString("description"));

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
	/**
	 * {@inheritDoc}
	 */
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

		if (address != null) {
			address = SQLQueryHelper.removeUnrecognizedChar(address);
		}

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
			stmt.setEscapeProcessing(true);
			stmt.executeUpdate(sql);
			stmt.close();
			setChanged();
			notifyObservers(get());
		} catch (SQLException ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "add"));
		}
		finally {
			Db.close();
		}
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public void remove(Element element) throws ClassCastException, PersistanceException {
		Connection conn;
		Statement stmt;

		String sql;
		
		long id = element.getId();
		
		/*Delete the client if there is no appointment associated */
		sql = "DELETE FROM clients WHERE client_id=" + id + " AND NOT EXISTS (SELECT client_id FROM appointments WHERE client_id= " + id + " )";
		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			setChanged();
			notifyObservers(get());
		} catch (SQLException ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "delete"));
		}
		finally {
			Db.close();
		}
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public void edit(Element element) throws ClassCastException, PersistanceException {
		Connection conn;
		Statement stmt;

		String sql;
		Client client = (Client) element;

		
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

		/*
		 * If there is an address specified, enapsulate apostrophes as they
		 * can cause SQL errors
		 */
		if (address != null) {
			address = SQLQueryHelper.removeUnrecognizedChar(address);
		}
		/*Updates all client attributes, in a futher version it would be
		 * better to only update changed fields */
		sql = "UPDATE clients SET " +
				"firstName='" + firstName + "', " +
				"lastName='" + lastName + "'," +
				"phone='" + phone + "'," +
				"address='" + address + "'," +
				"description='" + comment + "' " +
			 "WHERE client_id=" + client.getId();
		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			setChanged();
			notifyObservers(get());
		} catch (SQLException ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "update"));
		}
		finally {
			Db.close();
		}

	}

}
