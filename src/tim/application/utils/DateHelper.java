package tim.application.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
	public static int getHour(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("H");
		return Integer.parseInt(sdf.format(date));
	}
	
	public static int getMinutes(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		return Integer.parseInt(sdf.format(date));
	}
		
	
	public static int DateDiff(Date date1, Date date2){
		return (int) (date2.getTime()-date1.getTime())/60000;
		
	}
	
	public static  Date getToday() {
		return  new Date();  
	}
	
	public static Date getNextDay(Date day) {
		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();   
		cal.setTime(day);

		//---Next day = day + 1
		cal.add(GregorianCalendar.DATE, 1);

		//---Put it back in the Date object   
		return cal.getTime();  
	}
	
	public static Date getPreviousDay(Date day) {
		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();   
		cal.setTime(day);
		
		//---Previous day = day - 1
		cal.add(GregorianCalendar.DATE, -1);

		//---Put it back in the Date object   
		return cal.getTime();  
	}
}
