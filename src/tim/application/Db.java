package tim.application;

import java.sql.Connection;
import java.sql.DriverManager;

import tim.application.ErrorHandler;
import tim.application.CurrentClassGetter;;

public class Db {
	private static final String user = "tim", password = "tim";
	private static final String url = "jdbc:mysql://localhost:3306/tim?autoReconnect=true";
	private static Connection conn = null;

	public static Connection open() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch(Exception ex) {
			ErrorHandler.getException(ex, new CurrentClassGetter().getClassName(), "open");
		}

		return conn;
	}
	
	public static void close() {
		if (conn != null) {
			try {
			conn.close();
			conn = null;
			}
			catch (Exception ex) {
				ErrorHandler.getException(ex, new CurrentClassGetter().getClassName(), "close");
			}
		}
	}
	
	
}
