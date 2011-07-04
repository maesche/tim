package tim.application;

import java.sql.Connection;
import java.sql.DriverManager;

import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.CurrentClassGetter;

/**
 * Data Base Manager which gives and operates connections.
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class Db {
	private static Connection conn = null;
	/*incremental value, if not equal to 0, at least one connection is open */
	private static int nbConnRequest = 0;

	/**
	 * Opens and returns a DB connection for the Database type specified in tim.application.Config
	 * 
	 * @return Connection
	 * @throws PersistanceException
	 */
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
	 * Closes DB connection if there is exactly one open connection otherwise, nothing is done.
	 * 
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
