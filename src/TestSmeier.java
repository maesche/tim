import java.util.ArrayList;

import tim.calendar.model.Appointment;
import tim.calendar.model.AppointmentHandler;
import tim.calendar.model.Client;
import tim.calendar.model.Employee;
import tim.application.DateHelper;


public class TestSmeier {
	public static void main(String[] args) {
		
		AppointmentHandler appHandler = new AppointmentHandler();
		
		/*
		 * getElements test
		 */
		ArrayList<Appointment> appointments = appHandler.getElements(DateHelper.StringToDate("2011-05-13 8:45"), DateHelper.StringToDate("2011-05-14 11:45"));	
		
		for(Appointment appointment : appointments) {
			System.out.println(appointment);
		}
		
		
		/*
		 * add test
		 */
		/*Employee employee = new Employee(3, null, null);
		Client client = new Client(1, null, null);
		
		Appointment appointment = new Appointment( 
				DateHelper.StringToDate("2011-06-15 13:45:00"), 
				DateHelper.StringToDate("2011-06-15 14:45:00"),
				"test 4",
				"description 4",
				employee,
				client);
		
		appHandler.add(appointment);*/
		
		
	}
}
