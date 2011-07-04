package tim.application;

/**
 * Global register which holds all system relevant objects
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class GlobalRegistry {	

	/**
	 * Global registered system resources
	 */
	public static MVCLinker mvcLinker =  null;
	public static LanguageLinker languageLinker = null;
	public static XmlConfigHandler xmlConfigHandler = null;
	
	public static Resizer resizer = null;
}
