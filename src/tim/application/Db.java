package tim.application;

import java.sql.Connection;
import java.sql.DriverManager;

import tim.application.ErrorHandler;

public class Db {
	static String user = "root", password = "";
	static String url = "jdbc:mysql://localhost:3306/tim";;
	static Connection conn = null;

	/*
	 * public static void main(String[] args) throws Exception { connnection
	 * conn = getOracleJDBCconnnection(); if(conn!= null){
	 * System.out.println(”Got connnection.”); DatabaseMetaData meta =
	 * conn.getMetaData(); System.out.println(”Driver Name :
	 * “+meta.getDriverName()); System.out.println(”Driver Version :
	 * “+meta.getDriverVersion());
	 * 
	 * }else{ System.out.println(”Could not Get connnection”); } }
	 */

	public static Connection open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (conn != null) {
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception ex) {
			ErrorHandler.getException(ex);
		}

		return conn;
	}
	
	public static void close() {
		if (conn != null) {
			try {
			conn.close();
			}
			catch (Exception ex) {
				ErrorHandler.getException(ex);
			}
		}
	}
	
	
}
