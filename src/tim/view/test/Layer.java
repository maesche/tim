package tim.view.test;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;





class Layer extends JPanel {
	 
	public JLayeredPane layeredPane;
	public Dimension JLayerPaneDimension;

 
	public Layer (JLayeredPane layer)
	{
		super();
		this.JLayerPaneDimension = new Dimension(800,600);
		this.setPreferredSize(JLayerPaneDimension);
		
		
		this.layeredPane = layer;
		this.layeredPane.add(new CalendarContainer(),new Integer(0));
		this.layeredPane.add(new Table(),new Integer(-3));
		
    }
	
	
}
