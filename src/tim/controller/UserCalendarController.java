package tim.controller;

import java.util.ArrayList;
import java.util.Date;

import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;

public class UserCalendarController extends AbstractController {
	
	public ArrayList<Element> getEmployeeEvents(Employee employee, Date begin, Date end){
		return ((AppointmentModel) models.get("AppointmentModel")).get(employee, begin, end);
	}
}
