package tim.view.calendar;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AppointmentDialogController;
import tim.controller.DayViewController;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;


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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Aspect visuel
		this.setOpaque(false);
		setLayout(new GridLayout(employees.size(),1));
		this.setBounds(5, 19, 1000-86, 600);
		
		for(Element employee : employees){
			add(new UserCalendar((Employee)employee));
		}
	}
	
	public void validate(){
		int x = 200;
		int width=0;
		int y = 19;
		
		if(CalendarContainer.getCalendarGridWidth() > 0){
			width = CalendarContainer.getCalendarGridWidth();
			System.out.println(x);
		}
		if(CalendarContainer.getCalendarGridPersonWidth() > 0){
			x = CalendarContainer.getCalendarGridPersonWidth();
		}
		
		//this.setBounds(x, y, (int)CalendarContainer.getJLayerPaneDimension().getWidth()-x, (int)CalendarContainer.getJLayerPaneDimension().getHeight()-y);
		this.setBounds(x, y, width, (int)CalendarContainer.getJLayerPaneDimension().getHeight()-y);
		System.out.println("1.1 = " + this.getWidth() + "x" + this.getHeight());
	}
	

	
}
