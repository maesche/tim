package tim.application.exception;

public class ExceptionFormatter {
	public static String format(Exception ex, String className, String methodName) {
		String error = "--------------------------\n";
		error += "Class:\t\t" + className + "\n";
		error += "Method:\t\t" + methodName + "\n";
		error += "Exception:\t" + ex.getClass() + "\n";
		error += "Message\t\t" + ex.getMessage() + "\n";
		error += "--------------------------\n";

		return error;
	}
}
