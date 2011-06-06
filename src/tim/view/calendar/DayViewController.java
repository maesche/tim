package tim.view.calendar;

import java.util.ArrayList;

import tim.controller.AbstractController;
import tim.controller.AppointmentDialogController;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.EmployeeModel;

public class DayViewController extends AbstractController {
	
	public ArrayList<Element> getEmployees() {		
		return new EmployeeModel().get();
	}
}
