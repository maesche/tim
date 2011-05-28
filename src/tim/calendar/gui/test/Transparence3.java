package tim.calendar.gui.test;


import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.event.*;
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
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.show();
 
	}
 
	public void stateChanged(ChangeEvent e)
	{
 
	}
 
	public static void main (String args[]) {
 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    }
		catch (Exception e) {}
		new Transparence3();
 
	}
 
}
 

 
class MonContainer extends JPanel {
 
	private JLayeredPane layeredPane;
	private Dessin panel1;
	private Dessin panel2;
 
	public MonContainer (JLayeredPane aLayeredPane)
	{
		super();
		this.setPreferredSize(new Dimension(400,400));
		this.panel1 = new Dessin(50,50,30,30);
		this.panel2 = new Dessin(60,60,20,20);
		this.layeredPane = aLayeredPane;
		this.layeredPane.add(panel1,new Integer(-3000));
		this.layeredPane.add(panel2,new Integer(0));
    }
}
