package tim.application;

public class GlobalRegistry {	

	//Global accessible elements
	public static Config config = new Config();
	public static BootLoader bootLoader = new BootLoader(Config.CONFIG_PATH + "xml/application.xml");
	public static final MVCLinker mvcLinker =  new MVCLinker();
}
