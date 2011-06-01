package tim.application.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tim.application.Config;

public class DateHelper {

	public static Date StringToDate(String date) throws ParseException {
		return StringToDate(date, Config.DATE_FORMAT_SHORT);
	}
	
	public static Date StringToDate(String date, String dateFormat) throws ParseException {
		DateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.parse(date);
	}
	
	public static String DateToString(Date date) {
		return DateToString(date, Config.DATE_FORMAT_SHORT);
	}
	
	public static String DateToString(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
}
