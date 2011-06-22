package tim.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import tim.application.Config;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Calendar;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;

//import tim.application.Config;

public class CalendarController extends AbstractController {

	//__________________________________________________________________________________
	//
	//		Can occur when the "Today" button is pressed
	//__________________________________________________________________________________
	public ArrayList<Employee> today() 
	{
		
		GregorianCalendar today = new GregorianCalendar();
		
		today.

		int dayStart = Config.CALENDAR_DAY_START;
		int dayEnd = Config.CALENDAR_DAY_END;
		
		Date today = null;
		
		Date begin = null; 	//today + heure début
		Date end = null; 	//today + heure fin
		
		return getCalendars(begin, end);
	}
	
	public ArrayList<Employee> getCalendars(Date begin, Date end) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Appointment> appointments;
		EmployeeModel employeeModel = (EmployeeModel) this.models.get("EmployeeModel");
		AppointmentModel appointmentModel = (AppointmentModel) this.models.get("AppointmentModel");
		
		
		for (Element element: employeeModel.get()) {
			Employee employee = (Employee) element;
			Calendar calendar = employee.getCalendar();
			
			
			appointments = new ArrayList<Appointment>();
			
			
			ArrayList<Element> elements = appointmentModel.get(employee, begin, end);
			
			for (Element el : elements) {
				Appointment appointment = (Appointment) el;
				appointments.add(appointment);
			}

			calendar.setAppointments(appointments);

			employee.setCalendar(calendar);
			
			employees.add(employee);
		}
		
		return employees;
	}
}
