import tim.model.AbstractModel;
import tim.model.AppointmentModel;

import tim.view.Application;

import tim.controller.AbstractController;
import tim.controller.ApplicationController;


public class TestSmeier {
	public static void main(String[] args) {
		
		AbstractModel appointmentModel = new AppointmentModel();
		
		AbstractController applicationController = new ApplicationController(appointmentModel);
		
		
		applicationController.getTest();
		
		Application app = new Application();
		app.pack();
		app.setVisible(true);
		
		
	}
}
