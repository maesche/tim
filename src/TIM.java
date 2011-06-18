import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import tim.view.Application;

import tim.application.BootLoader;
import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.MVCLinker;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.ApplicationController;


public class TIM {
	
	private static void setUIFont(FontUIResource f)
	{
	    Enumeration<Object> keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements())
	    {
	        Object key = keys.nextElement();
	        Object value = UIManager.get(key);
	        if (value instanceof FontUIResource)
	        {
	            UIManager.put(key, f);
	        }
	        
	        if (value instanceof ColorUIResource && !((String) key).toLowerCase().endsWith("background")) {
	        	//UIManager.put(key, new ColorUIResource(Color.black));
	        }
	    }
	}
	
	public static void main(String[] args) {
		setUIFont (new FontUIResource(new Font("Arial Unicode MS", Font.BOLD, 14)));

		ApplicationController applicationController = new ApplicationController();
		applicationController.init();
		
		Application app = new Application(applicationController);
		
		GlobalRegistry.bootLoader.loadConfig();
		
		/*try {
			GlobalRegistry.mvcLinker.addObserverToModel("tim.model.Bootloader", app);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}*/
		

		
		

		app.setPreferredSize(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT));
		app.setVisible(true);
		app.pack();
		app.setLocationRelativeTo(null);
	}
}