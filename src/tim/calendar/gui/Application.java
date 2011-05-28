package tim.calendar.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import tim.application.ErrorHandler;

public class Application extends JFrame {
	
	public static void main(String[] args){
		Application app = new Application();
		app.pack();
		app.setTitle("calendar");
		app.setVisible(true);
		app.setSize(400, 200);
		
		//pour fermer l'application
		app.addWindowListener(new WindowAdapter(){
	
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				super.windowClosing(arg0);
				System.exit(0);
			}
			
		});	
	};
	
	
	
	public Application(){
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	    } catch (Exception ex) {
	            ErrorHandler.getException(ex, this.getClass().getName(), "Application()");
	    }
	    
	    
	    //container = new MonContainer(this.getLayeredPane());
        //this.setContentPane(container);
	    
	    //add(new Layered());
	    JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.add(new TimeLines(), new Integer(-3000));
		layeredPane.add(new TimeLines(), new Integer(0));
		
	    
	    
	}
	
}
