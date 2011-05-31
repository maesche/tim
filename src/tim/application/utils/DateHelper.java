package tim.application.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {

	private static final String timeZone = "Europe/Zurich";
	private static final String dateFormat = "yyyy-MM-dd HH:mm";

	public static Date StringToDate(String date) throws ParseException {
		DateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		Date ret = null;

		ret = sdf.parse(date);

		return ret;
	}

	public static String DateToString(Date date) {
		String ret = "";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

		ret = sdf.format(date);
		return ret;
	}
}
