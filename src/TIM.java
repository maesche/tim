import java.awt.Dimension;

import tim.model.AppointmentModel;

import tim.view.Application;

import tim.controller.ApplicationController;


public class TIM {
	public static void main(String[] args) {
		
		AppointmentModel appointmentModel = new AppointmentModel();
		
		ApplicationController applicationController = new ApplicationController();
		applicationController.addModel("appointment", appointmentModel);
		
		
		applicationController.getTest();
		
		Application app = new Application();
		app.setLocationRelativeTo(null);
		app.pack();
		app.setVisible(true);
		
		
	}
}
