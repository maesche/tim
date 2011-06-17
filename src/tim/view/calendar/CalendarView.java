package tim.view.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class CalendarView extends JPanel {
	 
	public JLayeredPane layeredPane;
	public Dimension JLayerPaneDimension;

 
	public CalendarView (JLayeredPane layer)
	{
		super();
		this.JLayerPaneDimension = new Dimension(800,600);

		this.setPreferredSize(JLayerPaneDimension);
		
		
		this.layeredPane = layer;
		this.layeredPane.add(new DayViewContainer(),new Integer(0));
		this.layeredPane.add(new DayTableView(),new Integer(-3));
		
    }
	
	
	// çA ne marche pas.
	/*public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    this.JLayerPaneDimension.setSize(this.getWidth(), this.getHeight());
	    this.setPreferredSize(this.JLayerPaneDimension);
	    this.setSize(this.JLayerPaneDimension);
	    System.out.println(this.getWidth() + "x" + this.getHeight());
	}*/
	
	
}
