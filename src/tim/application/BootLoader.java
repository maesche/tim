package tim.application;

import java.awt.Dimension;

import tim.application.exception.PersistanceException;
import tim.controller.CalendarController;
import tim.controller.Controller;
import tim.model.AppointmentModel;
import tim.model.ClientModel;
import tim.model.EmployeeModel;

public class BootLoader {		
	
	private static String configFile = null;
	
	/**
	 * 
	 * @param configFile 
	 * @throws PersistanceException
	 */
	public static void init(String configFilePath) throws PersistanceException {
		configFile = configFilePath;
		/*
		 * Register global system resources
		 * Order is important due to dependencies
		 */
		GlobalRegistry.mvcLinker = new MVCLinker();
		GlobalRegistry.languageLinker = new LanguageLinker();
		GlobalRegistry.mvcLinker.registerModel(new EmployeeModel());
		GlobalRegistry.mvcLinker.registerModel(new AppointmentModel());
		GlobalRegistry.mvcLinker.registerModel(new ClientModel());
		GlobalRegistry.resizer = new Resizer();
		
		
		GlobalRegistry.xmlConfigHandler = new XmlConfigHandler();
		GlobalRegistry.xmlConfigHandler.readConfig(configFile);
				
		GlobalRegistry.languageLinker.setLanguageDefault();
		
		GlobalRegistry.resizer.setDimension(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT));
		
		
		//GlobalRegistry.mvcLinker.registerController(new CalendarController());

	}
	
	public static void dispose() throws PersistanceException {
		GlobalRegistry.xmlConfigHandler.writeConfig(configFile);
	}
}
