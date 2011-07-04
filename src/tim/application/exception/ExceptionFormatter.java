package tim.application.exception;

/**
 * This class formats all exceptions thrown by the application to a specified format
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class ExceptionFormatter {
	public static String format(Exception ex, String className, String methodName) {
		String error = "";
		error += "Class:\t" + className + "\n";
		error += "Method:\t" + methodName + "\n";
		error += "Exception:\t" + ex.getClass() + "\n";
		error += "Message\t" + ex.getMessage() + "\n";
		error += "\n";

		return error;
	}
}
