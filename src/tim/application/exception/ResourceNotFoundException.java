package tim.application.exception;

/**
 * This Exception is thrown if the researched resource can not be found.
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String resource, String location) {
		super("The system resource '" + resource + "' doesn't exist in " + location);
	}
}
