/**
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 * 
 * @description Data Base Manager which gives and operates connections
 */
package tim.application;

import java.sql.Connection;
import java.sql.DriverManager;

import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.CurrentClassGetter;


public class Db {
	private static Connection conn = null;
	/*incremental value, if not equal to 0, at least one connection is open */
	private static int nbConnRequest = 0;

	public static Connection open() throws PersistanceException {
		try {
			Class.forName(Config.DB_DRIVER);
			if (conn == null) {
				conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PWD);
			}
			nbConnRequest++;
		} catch(Exception ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, new CurrentClassGetter().getClassName(), "close"));
		}
		return conn;
	}
	/**
	 * @description closes DB connection if there is exactly one open connection
	 * @throws PersistanceException
	 */
	public static void close() throws PersistanceException {
		nbConnRequest--;
		if (conn != null && nbConnRequest <= 0) {
			try {
			conn.close();
			conn = null;
			}
			catch (Exception ex) {
				throw new PersistanceException(ExceptionFormatter.format(ex, new CurrentClassGetter().getClassName(), "close"));
			}
		}
	}
	
	
}
