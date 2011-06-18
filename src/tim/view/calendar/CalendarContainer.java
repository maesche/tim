package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class CalendarContainer extends JPanel {
	
	private static Dimension JLayerPaneDimension;
	
	private CalendarView calendarView;
	private JLayeredPane layer;
	
	public CalendarContainer() {
		
		this.setLayout(new BorderLayout());
		
		setJLayerPaneDimension(new Dimension(1000,600));
		this.setPreferredSize(getJLayerPaneDimension());
		layer = new JLayeredPane();
		layer.setPreferredSize(getJLayerPaneDimension());
		

		layer.add(new DayViewContainer(),new Integer(0));
		layer.add(new DayTableView(),new Integer(-3));

		add(layer);
	}
	
	public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    
	    this.getJLayerPaneDimension().setSize(this.getWidth(), this.getHeight());
	    
	    this.setPreferredSize(this.getJLayerPaneDimension());
	    this.setSize(this.getJLayerPaneDimension());
	    //this.setBounds(0, 0, (int) this.getJLayerPaneDimension().getWidth(), (int) this.getJLayerPaneDimension().getHeight());
	    //System.out.println(this.getJLayerPaneDimension());
	    //this.setSize(this.JLayerPaneDimension);
	    //System.out.println(this.getWidth() + "x" + this.getHeight());
	}
	
	public void validate(){
		this.getJLayerPaneDimension().setSize(this.getWidth(), this.getHeight());
	    
	    this.setPreferredSize(this.getJLayerPaneDimension());
	    this.setSize(this.getJLayerPaneDimension());
	}

	public static void setJLayerPaneDimension(Dimension jLayerPaneDimension) {
		JLayerPaneDimension = jLayerPaneDimension;
	}

	public static Dimension getJLayerPaneDimension() {
		return JLayerPaneDimension;
	}
}
