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
import tim.model.AppointmentModel;


public class AppointmentDialogController extends Controller {

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
	
	
	public boolean checkAvailability(Appointment appointment) throws PersistanceException, ParseException {
		boolean canInsert = true;

		Date begin =  DateHelper.StringToDate(DateHelper.DateToString(appointment.getBegin(), Config.DATE_FORMAT_SHORT) + " 0:00", Config.DATE_FORMAT_LONG);
		Date end = DateHelper.StringToDate(DateHelper.DateToString(appointment.getEnd(), Config.DATE_FORMAT_SHORT));
		
		AppointmentModel appointmentModel = (AppointmentModel) models.get("AppointmentModel");
		
		
		ArrayList<Element> appointments = (ArrayList<Element>)appointmentModel.get((Employee)appointment.getEmployee(), begin, end);
		
		for (Element element : appointments) {
			Appointment app = (Appointment) element;
			
			Date a_begin = app.getBegin();
			Date a_end = app.getEnd();
			System.out.println("existant begin: " +a_begin + "end: " + a_end);
			System.out.println("nouveau begin: " +begin + "end: " + end);
			
			canInsert = (a_end.before(begin) || a_begin.after(end));
			System.out.println("canInsert: " + canInsert);
		}
		
		return canInsert;
	}
}
