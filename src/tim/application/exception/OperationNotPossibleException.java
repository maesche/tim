package tim.application.exception;

public class OperationNotPossibleException extends Exception {
	public OperationNotPossibleException(String operation, String help) {
		super("The operation '" + "' is not possible. Try " + ".");
	}
}
