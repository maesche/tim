package tim.application;

public class GlobalRegistry {	

	/**
	 * Global registered system resources
	 */
	public static MVCLinker mvcLinker =  null;
	public static LanguageLinker languageLinker = null;
	public static XmlConfigHandler xmlConfigHandler = null;
	
	public static Resizer resizer = new Resizer();
}
