package tim.view.calendar;


import java.awt.Color;
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
	int i;

	public DayViewContainer(){
		
		this.nbrPerson = 0;
		this.i = 0;
		
		//Initialisation du controller
		DayViewController controller = new DayViewController();
		controller.addModel(new EmployeeModel());
		
		ArrayList<Element> employees = controller.getEmployees();
		
		
		//Aspect visuel
		this.setOpaque(false);
		setLayout(new GridLayout(employees.size(),1));
		this.setBounds(0, 0, 800, 600);
		
		for(Element element : employees){
			Employee employee = (Employee) element;
			add(new UserCalendar(employee, employee.getColor()));
			i++;
		}
	}
	

	
}
