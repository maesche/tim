/**
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 * 
 * @description global register which holds system elements
 */
package tim.application;

public class GlobalRegistry {	

	/**
	 * Global registered system resources
	 */
	public static MVCLinker mvcLinker =  null;
	public static LanguageLinker languageLinker = null;
	public static XmlConfigHandler xmlConfigHandler = null;
	
	public static Resizer resizer = null;
}
