package tim.application;

import java.util.HashMap;



public final class BootLoader {
	
	private String xmlPath;
	//private HashMap<String, Object> configMap, systemConfig, calendarConfig;
	
	public BootLoader(String xmlPath) {
		this.xmlPath = xmlPath;
		/*configMap = new HashMap<String, Object>();
		systemConfig = new HashMap<String, Object>();
		calendarConfig = new HashMap<String, Object>();
		configMap.put("system", systemConfig);
		configMap.put("calendar", calendarConfig);
		
		systemConfig.put("date-format", null);
		systemConfig.put("time-format", null);
		systemConfig.put("db-url", null);
		systemConfig.put("db-driver", null);
		systemConfig.put("db-user", null);
		systemConfig.put("db-pwd", null);
		systemConfig.put("default-lang", null);
		
		calendarConfig.put("day-start", null);
		calendarConfig.put("day-end", null);
		calendarConfig.put("day-interval", null);*/
		
	}
	
	public void loadConfig() {
		XmlReader xmlFile = new XmlReader();
		//xmlFile.read(xmlPath, configMap);
		xmlFile.readConfig(xmlPath);
	}

	
}
