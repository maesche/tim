package tim.view.test;


import javax.swing.*;

import java.awt.*;
import java.awt.image.*;
import javax.swing.event.*;

import tim.application.ErrorHandler;

import java.awt.geom.*;
import java.io.*;
import java.util.*;
 
public class Transparence3 extends JFrame implements ChangeListener {
 
	private JSlider slider;
	private MonContainer container;
 
	public Transparence3 () {
 
		super("Transparence");
 
		slider = new JSlider(JSlider.HORIZONTAL,0,100,100);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
        slider.addChangeListener(this);
        container = new MonContainer(this.getLayeredPane());
        this.setContentPane(container);
 
		this.pack();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.show();
 
	}
 
	public void stateChanged(ChangeEvent e)
	{
 
	}
 
	public static void main (String args[]) {
 
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    }
		catch (Exception e) {}
		new Transparence3();*/
		
		try {
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			//ErrorHandler.getException(ex, this.getClass().getName(), "Application()");
		}
		new Transparence3();
 
	}
 
}