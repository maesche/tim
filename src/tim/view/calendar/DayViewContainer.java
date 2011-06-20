package tim.view.calendar;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.application.utils.CurrentClassGetter;
import tim.controller.AppointmentDialogController;
import tim.controller.DayViewController;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;
import tim.view.ExceptionView;


public class DayViewContainer extends JPanel {
	
	int nbrPerson;

	public DayViewContainer(){
		
		this.nbrPerson = 0;
		
		//Initialisation du controller
		DayViewController controller = new DayViewController();
		
		
		ArrayList<Element> employees = null;
		try {
			employees = controller.getEmployees();
		} catch (PersistanceException e) {
			new ExceptionView (e.toString());
		}
		
		//Aspect visuel
		this.setOpaque(false);
		setLayout(new GridLayout(employees.size(),1));
		
		for(Element employee : employees){
			add(new UserCalendar((Employee)employee));
		}
		validate();
	}
	
	public void validate(){
		int x = 200;
		int width=0;
		int y = 19;
		
		if(CalendarContainer.getCalendarHourWidth() > 0){
			width = CalendarContainer.getCalendarHourWidth();
		}
		if(CalendarContainer.getCalendarPersonColWidth() > 0){
			x = CalendarContainer.getCalendarPersonColWidth();
		}
		
		this.setBounds(x, y, width, (int)CalendarContainer.getCalendarDimension().getHeight()-y);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		validate();
	}
	

	
}
