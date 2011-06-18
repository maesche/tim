package tim.application;

import java.sql.Connection;
import java.sql.DriverManager;

import tim.application.utils.CurrentClassGetter;
import tim.application.utils.ErrorHandler;


public class Db {
	private static Connection conn = null;
	private static int nbConnRequest = 0;

	public static Connection open() {
		try {
			Class.forName(Config.DB_DRIVER);
			if (conn == null) {
				conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PWD);
			}
			nbConnRequest++;
		} catch(Exception ex) {
			ErrorHandler.getException(ex, new CurrentClassGetter().getClassName(), "open");
		}

		return conn;
	}
	
	public static void close() {
		nbConnRequest--;
		if (conn != null && nbConnRequest <= 0) {
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
