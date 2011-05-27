import java.util.ArrayList;

import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Client;
import tim.model.Element;
import tim.model.Employee;
import tim.model.Person;
import tim.view.Application;
import tim.application.CurrentClassGetter;
import tim.application.DateHelper;
import tim.application.ErrorHandler;


public class TestSmeier {
	public static void main(String[] args) {
		
		AppointmentModel appHandler = new AppointmentModel();
		
		/*
		 * getElements test
		 */
		ArrayList<Element> appointments = appHandler.get(DateHelper.StringToDate("2011-05-13 8:45"), DateHelper.StringToDate("2011-06-17 11:45"));	
		
		for(Element element : appointments) {
			Appointment appointment = (Appointment) element;
			System.out.println(appointment);
		}
		
		Application app = new Application();
		app.pack();
		app.setVisible(true);
		
		/*
		 * add test
		 */
		/*
		Person employee = new Employee(3, null, null);
		Person client = new Client(1, null, null);
		
		Appointment appointment = new Appointment( 
				DateHelper.StringToDate("2011-06-15 13:45:00"), 
				DateHelper.StringToDate("2011-06-15 14:45:00"),
				"test 4",
				"description 4",
				employee,
				client);
		
		try {
		appHandler.add(appointment);
		} 
		catch (ClassCastException ex) {
			ErrorHandler.getException(ex, new CurrentClassGetter().getClassName(), "main");
		}
		*/
		
	}
}
