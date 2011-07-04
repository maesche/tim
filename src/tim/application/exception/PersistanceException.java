package tim.application.exception;

/**
 * This Exception is thrown if a problem with the integrity of the application has been found
 * or when a database error occurs.
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class PersistanceException extends Exception {
	public PersistanceException(String exception) {
		super(exception);
	}
}
