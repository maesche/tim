package tim.application;

import java.awt.Color;


public class Config {
	public static String APPLICATION_MENU_FILE;
	public static String RESSOURCE_BUNDLE = "";
	
	public static String DB_USER = "tim";
	public static String DB_PWD = "tim";
	public static String DB_URL = "jdbc:mysql://localhost:3306/tim?autoReconnect=true";
	public static String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	public static String DATE_FORMAT_SHORT = "yyyy-MM-dd";
	public static String DATE_FORMAT_LONG = DATE_FORMAT_SHORT + " " + "HH:mm";
	public static String DATE_FORMAT_EVENT_HOUR = "HH:mm";
	
	public static int CALENDAR_DAY_START = 9;
	public static int CALENDAR_DAY_END = 19;
	public static int CALENDAR_DAY_INTERVAL = 15; //in minutes
	
	public static Color COLOR_USER [] = { new Color(200,200,200,200), new Color(200,255,200,200), new Color(100,8,4,200) , new Color(255,6,200,200)};
	
	public static int APPLICATION_DEFAULT_FRAME_WIDTH = 1024;
	public static int APPLICATION_DEFAULT_FRAME_HEIGHT = 768;

}
