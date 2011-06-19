import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import tim.view.Application;

import tim.application.BootLoader;
import tim.application.Config;
import tim.application.exception.PersistanceException;

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
	    }
	}
	
	public static void main(String[] args) {
		setUIFont (new FontUIResource(new Font("Arial Unicode MS", Font.BOLD, 14)));

		try {
			BootLoader.init(System.getProperty("user.dir") + "/config/application.xml");
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Application app = new Application();
	
		app.setPreferredSize(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT));
		app.setVisible(true);
		app.pack();
		app.setLocationRelativeTo(null);
	}
}
