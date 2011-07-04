package tim.application.exception;

/**
 * This Exception is thrown if an operation is not possible.
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class OperationNotPossibleException extends Exception {
	public OperationNotPossibleException(String operation, String help) {
		super("The operation '" + "' is not possible. Try " + ".");
	}
}
