package tim.application.utils;

public class CurrentClassGetter extends SecurityManager {

		  public String getClassName() {
		    return getClassContext()[1].getName();
		  }
}
