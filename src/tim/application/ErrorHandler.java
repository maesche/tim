package tim.application;

public class ErrorHandler {
	
	public static void getException(Exception ex) {
		System.err.println("Exception: " + ex.getMessage());
	}
}
