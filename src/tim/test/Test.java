package tim.test;

import java.text.ParseException;
import java.util.Date;


import tim.application.Config;
import tim.application.utils.DateHelper;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date test = null;
		try {
			test = DateHelper.StringToDate("2011-05-14 7:04", Config.DATE_FORMAT_LONG);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(DateHelper.getHour(test));
		System.out.println(DateHelper.getMinutes(test));
	}

}
