package tim.application;

import java.awt.Dimension;

import tim.application.exception.PersistanceException;
import tim.model.AppointmentModel;
import tim.model.ClientModel;
import tim.model.EmployeeModel;

/**
 * Loads and unloads system register and settings
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704 
 */
public class BootLoader {		
	
	private static String configFile = null;
	
	/**
	 * Registers global system resources with specified application settings
	 * @param configFilePath (Path to XML application configuration(
	 * @throws PersistanceException
	 */
	public static void init(String configFilePath) throws PersistanceException {
		configFile = configFilePath;

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

	}
	
	/**
	 * On unload saves application parameters to config file
	 * @throws PersistanceException
	 */
	public static void dispose() throws PersistanceException {
		GlobalRegistry.xmlConfigHandler.writeConfig(configFile);
	}
}
