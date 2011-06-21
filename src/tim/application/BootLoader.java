package tim.application;

import tim.application.exception.PersistanceException;
import tim.controller.CalendarController;
import tim.model.AppointmentModel;
import tim.model.ClientModel;
import tim.model.EmployeeModel;

public class BootLoader {		
	public static void init(String configFile) throws PersistanceException {
		/*
		 * Register global system resources
		 * Order is important due to dependencies
		 */
		GlobalRegistry.mvcLinker = new MVCLinker();
		GlobalRegistry.languageLinker = new LanguageLinker();
		GlobalRegistry.mvcLinker.registerModel(new EmployeeModel());
		GlobalRegistry.mvcLinker.registerModel(new AppointmentModel());
		GlobalRegistry.mvcLinker.registerModel(new ClientModel());
		
		GlobalRegistry.mvcLinker.registerController(new CalendarController());
		
		new XmlReader().readConfig(configFile);
				
		GlobalRegistry.languageLinker.setLanguageDefault();		
	}
}
