package tim.application.utils;

public class SQLQueryHelper {

	public static String removeUnrecognizedChar(String string) {
		return string.replaceAll("'", "\\\\'");
	}
	
	public static String insertCharForNormalText(String string) {
		return string.replaceAll("\\\\'", "'");
	}
}
