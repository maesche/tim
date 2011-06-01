import tim.model.AbstractModel;
import tim.model.AppointmentModel;

import tim.view.Application;

import tim.controller.ApplicationController;
import tim.controller.AppointmentController;


public class TIM {
	public static void main(String[] args) {
		
		/*AppointmentModel appointmentModel = new AppointmentModel();
		
		ApplicationController applicationController = new ApplicationController();
		applicationController.addModel("appointment", appointmentModel);
		
		
		applicationController.getTest();*/
		
		AbstractModel appointmentModel = new AppointmentModel();
		
		AppointmentController appointmentController = new AppointmentController();
		appointmentController.addModel(appointmentModel);
		
		
		Application app = new Application();
		app.setLocationRelativeTo(null);
		app.pack();
		app.setVisible(true);
		
		
	}
}
