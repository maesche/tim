import java.awt.Dimension;

import tim.model.AbstractModel;
import tim.model.AppointmentModel;

import tim.view.Application;

import tim.application.Config;
import tim.controller.ApplicationController;
import tim.controller.AppointmentDialogController;


public class TIM {
	public static void main(String[] args) {
		
		AbstractModel appointmentModel = new AppointmentModel();
		
		ApplicationController applicationController = new ApplicationController();
		applicationController.addModel(appointmentModel);
		
		
		applicationController.getTest();
		
		/*AbstractModel appointmentModel = new AppointmentModel();
		
		AppointmentController appointmentController = new AppointmentController();
		appointmentController.addModel(appointmentModel);*/
		
		
		Application app = new Application();

		app.setVisible(true);
		app.setPreferredSize(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT));

		app.pack();
		app.setLocationRelativeTo(null);
		
		
	}
}
