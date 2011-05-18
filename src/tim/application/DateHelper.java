package tim.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {
	
	private static final String timeZone = "Europe/Zurich";
	private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
	
	public static Date StringToDate(String date) {
		DateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		Date ret = null;
		try {
			ret = sdf.parse(date);
		} catch (ParseException ex) {
			ErrorHandler.getException(ex, "tim.application.DateHelper", "StringToDate");
		}
		return ret;
	}
	
	public static String DateToString(Date date) {
		String ret = "";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		ret = sdf.format(date);
		return ret;
	}
}
