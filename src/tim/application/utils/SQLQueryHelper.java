package tim.application.utils;

/**
 * This class is a helper for escaping apostrophes in SQL queries
 * @param label
 * @param text
 */
public class SQLQueryHelper {

	public static String removeUnrecognizedChar(String string) {
		return string.replaceAll("'", "\\\\'");
	}
	
	public static String insertCharForNormalText(String string) {
		return string.replaceAll("\\\\'", "'");
	}
}
