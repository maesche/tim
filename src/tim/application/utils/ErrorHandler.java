package tim.application.utils;

public class ErrorHandler {
	
	/**
	 * @deprecated please use tim.application.exception and forward Exceptions to view
	 * @param ex
	 * @param className
	 * @param methodName
	 */
	public static void getException(Exception ex, String className, String methodName) {
		String error = "--------------------------\n";
		error += "Class:\t\t" + className + "\n";
		error += "Method:\t\t" + methodName + "\n";
		error += "Exception:\t" + ex.getClass() + "\n";
		error += "Message\t\t" + ex.getMessage() + "\n";
		error += "--------------------------\n";

		System.err.println(error);
	}
}
