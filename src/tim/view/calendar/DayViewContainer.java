package tim.view.calendar;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tim.application.Config;
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
		controller.addModel(new EmployeeModel());
		
		ArrayList<Element> employees = controller.getEmployees();
		
		
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
		int y = 19;
		this.setBounds(x, y, (int)CalendarContainer.getJLayerPaneDimension().getWidth()-x, (int)CalendarContainer.getJLayerPaneDimension().getHeight()-y);
	}
	
	public void Validate(){
		//this.setBounds(DayTableView.getPersonColumnWidth(), 19, 600, 600);
	}
	

	
}
