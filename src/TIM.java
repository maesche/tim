import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;

import tim.view.Application;

import tim.application.Config;
import tim.controller.ApplicationController;


public class TIM {
	
	private static void setUIFont(javax.swing.plaf.FontUIResource f)
	{
	    Enumeration<Object> keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements())
	    {
	        Object key = keys.nextElement();
	        Object value = UIManager.get(key);
	        if (value instanceof javax.swing.plaf.FontUIResource)
	        {
	            UIManager.put(key, f);
	        }
	    }
	}
	
	public static void main(String[] args) {
		setUIFont (new javax.swing.plaf.FontUIResource(new Font("Arial Unicode MS", Font.BOLD, 14)));
		ApplicationController applicationController = new ApplicationController();
		applicationController.init();
		
		Application app = new Application(applicationController);

		app.setPreferredSize(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT));
		app.setVisible(true);
		app.pack();
		app.setLocationRelativeTo(null);


	}
}
