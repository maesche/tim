package tim.application.exception;

public class ExceptionFormatter {
	public static String format(Exception ex, String className, String methodName) {
		String error = "";
		error += "Class:\t" + className + "\n";
		error += "Method:\t" + methodName + "\n";
		error += "Exception:\t" + ex.getClass() + "\n";
		error += "Message\t" + ex.getMessage() + "\n";
		error += "\nsd";

		return error;
	}
}
