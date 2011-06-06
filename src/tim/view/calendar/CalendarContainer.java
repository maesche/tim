package tim.view.calendar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class CalendarContainer extends JPanel {
	CalendarView calendarView;
	JLayeredPane layer;
	public Dimension JLayerPaneDimension;
	public CalendarContainer() {

		JLayerPaneDimension = new Dimension(800,600);
		this.setPreferredSize(JLayerPaneDimension);
		layer = new JLayeredPane();
		layer.setPreferredSize(JLayerPaneDimension);
		

		layer.add(new DayViewContainer(),new Integer(0));
		layer.add(new DayTableView(),new Integer(-3));

		add(layer);
	}
	
	/*public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    this.JLayerPaneDimension.setSize(this.getWidth(), this.getHeight());
	    this.setPreferredSize(this.JLayerPaneDimension);
	    this.setSize(this.JLayerPaneDimension);
	    System.out.println(this.getWidth() + "x" + this.getHeight());
	}*/
}
