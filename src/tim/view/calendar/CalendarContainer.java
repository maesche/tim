package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.controller.CalendarController;
import tim.model.Employee;
import tim.view.ParentView;



public class CalendarContainer extends JPanel implements ParentView {
	

	
	private JLayeredPane layer;
	private Dimension calendarSize;
	
	private	DayViewContainer dayViewContainer;
	private DayTableView dayTableView;
	
	private CalendarController controller;
	
	private ArrayList<Employee> employees;
	
	private Dimension dimension;
	
	public CalendarContainer(Date begin, Date end){
		this.calendarSize = null;
		dimension = new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT);
		
		controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		
		try {
			employees = controller.getCalendars(begin, end);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setLayout(new BorderLayout());
		
		
		
		this.layer = new JLayeredPane();
		
		//this.setJLayerPaneDimension(dimension);
		layer.setPreferredSize(dimension);		
		
		//controller.addView("DayViewContainer", new DayViewContainer());
		//controller.addView("DayTableView", new DayTableView());
		try {
			this.dayViewContainer = new DayViewContainer();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dayTableView = new DayTableView();
		
		dayViewContainer.setData(employees);
		
		int hoursPerDay = controller.getHoursPerDay();
		Vector<String> columnNames = new Vector<String>();
		
		columnNames.add("Collaborateur");
		String h;

		for(int i=1; i<hoursPerDay+1; i++){
			h = Integer.toString(i-1 + Config.CALENDAR_DAY_START);
			
			columnNames.add(h + ":00");
		}
		dayTableView.setColumnNames(columnNames);
		
		dayTableView.setData(employees);
		//dayTableView.setRowHeight(200);
		dayTableView.setDimension(dimension);
		dayTableView.load();
		
		layer.add(dayViewContainer,new Integer(0));
		layer.add(dayTableView,new Integer(-3));
		

		add(layer);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    
	    setPreferredSize(this.getSize());
	    
	    //this.controller.updateCalendarDimension(this.calendarSize,this.dayViewContainer.getSize());
	    
	    //this.calendarDimension.setSize(this.getWidth(), this.getHeight());
	    
	    
	    
	   
	    //this.controller.setCalendarSize(this.getWidth(), this.getHeight());
	    
	    
	    
	    //validate();
	}
	
	public void validate(){
		
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String action, Object value) {
		// TODO Auto-generated method stub
		
	}
}
