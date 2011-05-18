package tim.application;

public class ErrorHandler {
	
	public static void getException(Exception ex) {
		//System.err.println(ex.getClass() + ": " + ex.getMessage() + ex.toString());
		ex.printStackTrace();
	}
}
