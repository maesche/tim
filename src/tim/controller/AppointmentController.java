package tim.controller;

import java.text.ParseException;
import java.util.Date;

import tim.application.utils.DateHelper;
import tim.model.Appointment;
import tim.model.Person;


public class AppointmentController extends AbstractController {

	public void save(Person employee, Person client, String date, int beginH, int beginM, int endH, int endM, String description) throws ParseException {
		Date begin = DateHelper.StringToDate(date + " " + String.valueOf(beginH) + ":" + String.valueOf(beginM));
		Date end = DateHelper.StringToDate(date + " " + String.valueOf(endH) + ":" + String.valueOf(endM));
		
		Appointment appointment = new Appointment(begin, end, "", description, employee, client);
		
		this.model.add(appointment);
	}
	
	public void remove() {
		
	}
	
	public void edit() {
		
	}
}
