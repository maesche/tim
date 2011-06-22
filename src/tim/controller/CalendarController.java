package tim.controller;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.Calendar;

import tim.application.Config;
//import tim.application.utils.DateHelper;
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
	//		Method todayDay. Can occur when the "Today" button is pressed
	//__________________________________________________________________________________
	public ArrayList<Employee> todayDay() 
	{
		//---Today date
		Date dayToday = new Date();

		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		//Calendar cal = Calendar.getInstance();   
		cal.setTime(dayToday);
		
		//---Put it back in the Date object   
		Date begin = setupDate(cal, Config.CALENDAR_DAY_START).getTime(); 
		Date end = setupDate(cal, Config.CALENDAR_DAY_END).getTime();
		
		return getCalendars(begin, end);
	}
	
	//__________________________________________________________________________________
	//
	//		Method nextDay. Can occur when the "Next Day" button is pressed
	//__________________________________________________________________________________
	public ArrayList<Employee> nextDay(Date day) 
	{
		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();   
		cal.setTime(day);
		
		//---Next day = day + 1
		cal.add(GregorianCalendar.DATE, 1);

		//---Put it back in the Date object   
		Date begin = setupDate(cal, Config.CALENDAR_DAY_START).getTime(); 
		Date end = setupDate(cal, Config.CALENDAR_DAY_END).getTime();
		
		return getCalendars(begin, end);
	}
	
	//__________________________________________________________________________________
	//
	//	Method previousDay. Can occur when the "PreviousDay Day" button is pressed
	//__________________________________________________________________________________
	public ArrayList<Employee> previousDay(Date day) 
	{
		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();   
		cal.setTime(day);
		
		//---Next day = day - 1
		cal.add(GregorianCalendar.DATE, -1);

		//---Put it back in the Date object   
		Date begin = setupDate(cal, Config.CALENDAR_DAY_START).getTime(); 
		Date end = setupDate(cal, Config.CALENDAR_DAY_END).getTime();
		
		return getCalendars(begin, end);
	}
	
	//__________________________________________________________________________________
	//
	//		Method to setup the date (Hour, Minute, Second, Millisecond
	//__________________________________________________________________________________
	private GregorianCalendar setupDate(GregorianCalendar cal, int hour)
	{
		//---Set the start time of the day
		cal.set(GregorianCalendar.HOUR, hour);   
		cal.set(GregorianCalendar.MINUTE, 0);   
		cal.set(GregorianCalendar.SECOND, 0);   
		cal.set(GregorianCalendar.MILLISECOND, 0);
		
		return cal;
	}
	
	//__________________________________________________________________________________
	//
	//		Method getCalendars ; Start and End date for each Employee
	//__________________________________________________________________________________
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
