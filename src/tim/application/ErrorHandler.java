package tim.application;

public class ErrorHandler {
	
	public static void getException(Exception ex, String className, String methodName) {
		String error = "--------------------------\n";
		error += "Class:\t" + className + "\n";
		error += "Method:\t" + methodName + "\n";
		error += "Message\t" + ex.getMessage() + "\n";
		error += "--------------------------\n";

		System.err.println(error);
		//ex.printStackTrace();
	}
}
