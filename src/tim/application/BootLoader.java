package tim.application;

public final class BootLoader {
	
	private String xmlPath;
	
	public BootLoader(String xmlPath) {
		this.xmlPath = xmlPath;
		Config.APPLICATION_MENU_FILE = "File";
	}
	
	
	
}
