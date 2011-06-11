package tim.view.test;


import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import tim.view.calendar.CalendarView;



 
public class Application extends JFrame{
 
	private CalendarView layer;
	public Dimension appSize;
 

	public Application () {
 
		super();
 
        layer = new CalendarView(this.getLayeredPane());
        this.setContentPane(layer);
        
        
 
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
 
	public static void main (String args[]) {
 
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			//ErrorHandler.getException(ex, this.getClass().getName(), "Application()");
		}
		new Application();
 
	}

 
}