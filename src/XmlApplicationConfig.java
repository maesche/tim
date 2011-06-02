//__________________________________________________________________________________
//
//	Project: 		TIM (Time Is Money)
//	class:			XmlApplicationConfig
//	Authors: 		Stefan Meier ; Mathieu Noverraz ; Alain Bellatalla
//	School team: 	IGL3
//	Creation Date: 	02.06.2010
//	Last update:
//	Comments:		This class is the configuration of TIM application
//__________________________________________________________________________________

//import java.sql.Date;
import java.util.Date;
//import java.util.GregorianCalendar;

public class XmlApplicationConfig 
{
	//---Date Format
	private String dateFormat;
	
	//---Default Languaguage
	private String defaultLanguage;
	  
	//---Date available from
	private Date minDate;
	
	//---Date available to
	private Date maxDate;
	
	//---Time begining of the day (hour)
	private Integer startTimeHour;
	
	//---Time begining of the day (minute)
	private Integer startTimeMinute;
	
	//---Time ending of the day (hour)
	private Integer endTimeHour;
	
	//---Time ending of the day (minute)
	private Integer endTimeMinute;
	
	//---Minimum interval in minute (ex.: 15 min)
	private Integer interval;
	
	//---Default color
	
	//...
	
	//---Default constructor
	public XmlApplicationConfig()
	{
		dateFormat ="dd.mm.yyyy";
		defaultLanguage = "fr";
		minDate = new Date(2010, 12, 31);
		maxDate = new Date(2020, 12, 31);
		startTimeHour = 9;
		startTimeMinute = 0;
		endTimeHour = 19;
		endTimeMinute = 0;
		interval = 15;
	}
	
	//---Constructor initialization
	public XmlApplicationConfig(String pDateFormat, String pdefaultLanguage, 
				  				Date pMinDate, Date pMaxDate, 
		  						Integer pStartTimeHour, Integer pStartTimeMinute,
		  						Integer pEndTimeHour, Integer pEndTimeMinute,
		  						Integer pInterval)
	{
		dateFormat = pDateFormat;
		defaultLanguage = pdefaultLanguage;
		minDate = pMinDate;
		maxDate = pMaxDate;
		startTimeHour = pStartTimeHour;
		startTimeMinute = pStartTimeMinute;
		endTimeHour = pEndTimeHour;
		endTimeMinute = pEndTimeMinute;
		interval = pInterval;
	}

	//______________________________________________________________________________
	//
	//			Accessor
	//______________________________________________________________________________
	  
	public String getDateFormat()
	{
		return dateFormat;
	}
	
	public String getDefaultLanguage()
	{
		return defaultLanguage;
	}
	
	public Date getMinDate()
	{
		return minDate;
	}
	
	public Date getMaxDate()
	{
		return maxDate;
	}
	
	public Integer getStartTimeHour()
	{
		return startTimeHour;
	}
	
	public Integer getStartTimeMinute()
	{
		return startTimeMinute;
	}
	
	public Integer getEndTimeHour()
	{
		return endTimeHour;
	}
	
	public Integer getEndTimeMinute()
	{
		return endTimeMinute;
	}
	
	public Integer getInterval()
	{
		return interval;
	}
	
	//______________________________________________________________________________
	//
	//			MUTATEURS
	//______________________________________________________________________________
	 
	public void setDateFormat(String pDateFormat)
	{
		dateFormat = pDateFormat;
	}
	
	public void setDefaultLanguage(String pDefaultLanguage )
	{
		defaultLanguage = pDefaultLanguage ;
	}
	
	public void setMinDate(Date pMinDate)
	{
		minDate = pMinDate;
	}
	
	public void setMaxDate(Date pMaxDate)
	{
		maxDate = pMaxDate;
	}
	
	public void setStartTimeHour(Integer pStartTimeHour)
	{
		startTimeHour = pStartTimeHour;
	}
	
	public void setStartTimeMinute(Integer pStartTimeMinute)
	{
		startTimeMinute = pStartTimeMinute;
	}
	
	public void setEndTimeHour(Integer pEndTimeHour)
	{
		endTimeHour = pEndTimeHour;
	}
	
	public void setEndTimeMinute(Integer pEndTimeMinute)
	{
		endTimeMinute = pEndTimeMinute;
	}
	
	public void setInterval(Integer pInterval)
	{
		interval = pInterval;
	}
}