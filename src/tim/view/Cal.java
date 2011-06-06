package tim.view;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



import javax.swing.JFrame;
import javax.swing.UIManager;

import tim.application.utils.ErrorHandler;
import tim.view.test.Calendrier;



public class Cal extends JFrame  {
	
	public static void main(String[] args){
		Cal testApp = new Cal();
		testApp.pack();
		testApp.setVisible(true);
		testApp.setSize(400, 200);
		
		//pour fermer l'application
		testApp.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				super.windowClosing(arg0);
				System.exit(0);
			}
			
		});	
	}
	
	
	public Cal(){
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	    } catch (Exception ex) {
	            ErrorHandler.getException(ex, this.getClass().getName(), "Application()");
	    }
		
		
		int nbrPerson = 3;
		
		
		setLayout(new GridLayout(nbrPerson,1));
        add(new Calendrier());
        add(new Calendrier());
        add(new Calendrier());
		
	}

}
