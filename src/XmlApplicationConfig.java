//import java.sql.Date;
import java.util.Date;

public class XmlApplicationConfig 
{
	//---Format de la date
	private String dateFormat;
	
	//---Languaguage par défaut
	private String defaultLanguage;
	  
	//---Date min possible
	private Date minDate;
	
	//---Date max possible
	private Date maxDate;
	
	//---Début de la journée commence à (heure)
	private Integer startTimeHour;
	
	//---Début de la journée commence à (minute)
	private Integer startTimeMinute;
	
	//---Fin de la journée se termine à (heure)
	private Integer endTimeHour;
	
	//---Fin de la journée se termine à (minute)
	private Integer endTimeMinute;
	
	//---Intervale minimum en minute (découpage minimum, ex.: 15 min)
	private Integer interval;
	
	//---Couleur par défaut
	
	//...
	
	//---Constructeur par défaut
	@SuppressWarnings("deprecation")
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
	
	//---Constructeur d'initialisation
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
	//			ACCESSEURS
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