package tim.application;

import java.util.ResourceBundle;


public class Config {
	public static String DB_USER = null;
	public static String DB_PWD = null;
	public static String DB_URL = null;
	public static String DB_DRIVER = null;
	
	public static String DEFAULT_LANG = null;
	
	public static String DATE_FORMAT_SHORT = "yyyy-MM-dd";
	
	public static String TIME_FORMAT = "HH:mm";
	public static final String DATE_FORMAT_LONG = DATE_FORMAT_SHORT + " " + TIME_FORMAT;
	
	public static int CALENDAR_DAY_START = 8;
	public static int CALENDAR_DAY_END = 19;
	public static int CALENDAR_DAY_INTERVAL = 15;
	

	public static ResourceBundle RESSOURCE_BUNDLE = null;
	
	public static final int CALENDAR_EVENT_ALPHA = 150;
	public static int APPLICATION_DEFAULT_FRAME_WIDTH = 1024;
	public static int APPLICATION_DEFAULT_FRAME_HEIGHT = 768;
	public static final String APPLICATION_PATH =  System.getProperty("user.dir") + "/";
	public static final String CONFIG_PATH = APPLICATION_PATH + "config/";
}
