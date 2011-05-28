package tim.controller;

import java.util.ArrayList;

import tim.application.DateHelper;
import tim.model.AbstractModel;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;

public class ApplicationController extends AbstractController {
	
	
	public ApplicationController(AbstractModel model) {
		super(model);
	}
	
	public void getTest() {
		AppointmentModel appointmentModel = (AppointmentModel) this.model;
		/*
		 * getElements test
		 */
		ArrayList<Element> appointments = appointmentModel.get(DateHelper.StringToDate("2011-05-13 8:45"), DateHelper.StringToDate("2011-06-17 11:45"));	
		
		for(Element element : appointments) {
			Appointment appointment = (Appointment) element;
			System.out.println(appointment);
		}
		

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
