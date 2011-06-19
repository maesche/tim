package tim.application.exception;

public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String resource, String location) {
		super("The system resource '" + resource + "' doesn't exist in " + location);
	}
}
