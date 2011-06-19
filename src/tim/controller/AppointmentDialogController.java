package tim.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.model.AbstractModel;
import tim.model.Appointment;
import tim.model.Client;
import tim.model.ClientModel;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;


public class AppointmentDialogController extends AbstractController {

	public boolean save(Employee employee, Client client, String date, int beginH, int beginM, int endH, int endM, String description) throws ParseException, ClassCastException, PersistanceException {
		
		if (employee == null) {
			employee = new Employee(1, "test", "test", null);
		}
		
		Date begin = DateHelper.StringToDate(date + " " + String.valueOf(beginH) + ":" + String.valueOf(beginM), Config.DATE_FORMAT_LONG);
		Date end = DateHelper.StringToDate(date + " " + String.valueOf(endH) + ":" + String.valueOf(endM), Config.DATE_FORMAT_LONG);
		
		Appointment appointment = new Appointment(begin, end, description, employee, client);
		
		this.models.get("AppointmentModel").add(appointment);

		return true;
	}
	
	public void remove() {
		
	}
	
	public void edit() {
		
	}
	
	public ArrayList<Element> getClients() throws PersistanceException {		
		return new ClientModel().get();
	}
}
