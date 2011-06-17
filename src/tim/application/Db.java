package tim.application;

import java.sql.Connection;
import java.sql.DriverManager;

import tim.application.utils.CurrentClassGetter;
import tim.application.utils.ErrorHandler;


public class Db {
	private static Connection conn = null;
	private static int connectionID = 0;

	public static Connection open() {
		try {
			Class.forName(Config.DB_DRIVER);
			if (conn == null) {
				conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PWD);
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
