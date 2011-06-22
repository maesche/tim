package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import tim.application.Config;



public class CalendarContainer extends JPanel {
	
	private static Dimension calendarDimension;
	private static int calendarHourWidth;
	private static int calendarPersonColWidth;
	
	private JLayeredPane layer;
	
	public CalendarContainer() throws ParseException {
		
		this.calendarHourWidth = 0;
		
		this.setLayout(new BorderLayout());
		
		
		this.layer = new JLayeredPane();
		
		setJLayerPaneDimension(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH,600));
		this.setPreferredSize(getCalendarDimension());		
		
		
		this.layer.add(new DayViewContainer(),new Integer(0));
		this.layer.add(new DayTableView(),new Integer(-3));
		

		add(this.layer);
	}
	
	public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    validate();
	}
	
	public void validate(){
		this.getCalendarDimension().setSize(this.getWidth(), this.getHeight());
	    
	    this.setPreferredSize(this.getCalendarDimension());
	    //this.setSize(this.getCalendarDimension());
	}

	public static void setJLayerPaneDimension(Dimension jLayerPaneDimension) {
		calendarDimension = jLayerPaneDimension;
	}

	public static Dimension getCalendarDimension() {
		return calendarDimension;
	}
	
	public static void setCalendarHourWidth(int width){
		calendarHourWidth = width;
	}
	public static int getCalendarHourWidth(){
		return calendarHourWidth;
	}
	
	public static int getCalendarPersonColWidth(){
		return calendarPersonColWidth;
	}
	public static void setCalendarPersonColWidth(int width){
		calendarPersonColWidth = width;
	}
}
