package tim.view.calendar;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class CalendarContainer extends JPanel {
	CalendarView calendarView;
	JLayeredPane layer;
	public Dimension JLayerPaneDimension;
	public CalendarContainer() {
		layer = new JLayeredPane();
		this.JLayerPaneDimension = new Dimension(300,300);
		this.setPreferredSize(JLayerPaneDimension);

		

		layer.add(new DayViewContainer(),new Integer(0));
		layer.add(new DayTableView(),new Integer(-3));

		add(new JLabel("test"));
		add(layer);
	}
}
