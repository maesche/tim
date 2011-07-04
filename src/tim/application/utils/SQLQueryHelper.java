package tim.application.utils;

/**
 * This class is a helper for escaping apostrophes in SQL queries
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class SQLQueryHelper {

	public static String removeUnrecognizedChar(String string) {
		return string.replaceAll("'", "\\\\'");
	}
	
	public static String insertCharForNormalText(String string) {
		return string.replaceAll("\\\\'", "'");
	}
}
