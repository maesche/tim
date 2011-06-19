package tim.controller;

import java.util.ArrayList;

import tim.application.GlobalRegistry;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.EmployeeModel;

public class DayViewController extends AbstractController {
	
	public ArrayList<Element> getEmployees() {	
		return this.models.get("EmployeeModel").get();
	}
}
