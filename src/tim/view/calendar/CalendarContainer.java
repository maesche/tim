package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.ParseException;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.controller.CalendarController;



public class CalendarContainer extends JPanel {
	
	private static Dimension calendarDimension;
	private static int calendarHourWidth;
	private static int calendarPersonColWidth;
	
	private JLayeredPane layer;
	
	
	CalendarController controller;
	
	public CalendarContainer() throws ParseException {
		
		this.controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		CalendarContainer.calendarHourWidth = 0;
		
		this.setLayout(new BorderLayout());
		
		
		
		this.layer = new JLayeredPane();
		
		setJLayerPaneDimension(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH,1000));
		this.setPreferredSize(getCalendarDimension());		
		
		controller.addView("DayViewContainer", new DayViewContainer());
		controller.addView("DayTableView", new DayTableView());
		
		this.layer.add((DayViewContainer) controller.getViews("DayViewContainer"),new Integer(0));
		this.layer.add((DayTableView) controller.getViews("DayTableView"),new Integer(-3));
		

		add(this.layer);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    CalendarContainer.getCalendarDimension().setSize(this.getWidth(), this.getHeight());
	    
	    this.setPreferredSize(CalendarContainer.getCalendarDimension());
	    
	    CalendarContainer.calendarDimension.setSize(this.getWidth(), this.getHeight());
	    
	    
	    
	   
	    //this.controller.setCalendarSize(this.getWidth(), this.getHeight());
	    
	    
	    
	    //validate();
	}
	
	/*public void validate(){
		this.getCalendarDimension().setSize(this.getWidth(), this.getHeight());
	    
	    this.setPreferredSize(this.getCalendarDimension());
	    //this.setSize(this.getCalendarDimension());
	}*/

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
