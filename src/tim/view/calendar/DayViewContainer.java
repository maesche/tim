package tim.view.calendar;


import java.awt.Graphics;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.controller.CalendarController;
import tim.model.Employee;
import tim.view.ExceptionView;


public class DayViewContainer extends JPanel {
	
	CalendarController controller;

	public DayViewContainer() throws ParseException{		
		//Init controller
		this.controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		
		//Date selector
		Date begin = null;
		try {
			begin = DateHelper.StringToDate("2011-05-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = null;
		try {
			end = DateHelper.StringToDate("2011-06-15");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Connection to controller
		ArrayList<Employee> employees = null;
		try {
			employees = controller.getCalendars(begin, end);
		} catch (PersistanceException e) {
			new ExceptionView (e.toString());
		}
		
		//Visual aspect
		this.setOpaque(false);
		setLayout(new GridLayout(employees.size(),1));
		
		for(Employee employee : employees){
			add(new UserCalendar(employee));
		}
		
		
	}
	
	public void validate(){
		int x = 200;
		int width=0;
		int height;
		int y = 19;
		
		/*if(CalendarContainer.getCalendarHourWidth() > 0){
			width = CalendarContainer.getCalendarHourWidth();
		}
		if(CalendarContainer.getCalendarPersonColWidth() > 0){
			x = CalendarContainer.getCalendarPersonColWidth();
		}
		
		this.setBounds(x, y, width, (int)CalendarContainer.getCalendarDimension().getHeight()-y);*/
		
		//this.controller.setCalendarSize(this.getWidth(), this.getHeight());
		
		//System.out.println(this.getWidth() +" "+ this.getHeight());
		this.controller.updateCalendarDimension();
		x = (int) this.controller.getDayViewContainerPlacement().getWidth();
		y = (int) this.controller.getDayViewContainerPlacement().getHeight();
		width = (int) this.controller.getDayViewContainerSize().getWidth();
		height = (int) this.controller.getDayViewContainerSize().getHeight();
		//this.setSize(this.controller.getDayViewContainerSize());
		
		System.out.println(x +" "+ y  +" "+ width  +" "+ height);
		this.setBounds(x, y, width, height);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		validate();
		
		
	}
	

	
}
