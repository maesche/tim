package tim.application.utils;

/**
 * This class permits to get the class name of a static class
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class CurrentClassGetter extends SecurityManager {
		  public String getClassName() {
		    return getClassContext()[1].getName();
		  }
}
