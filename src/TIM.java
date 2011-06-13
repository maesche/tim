import java.awt.Dimension;

import tim.view.Application;

import tim.application.Config;
import tim.controller.ApplicationController;


public class TIM {
	public static void main(String[] args) {
		ApplicationController applicationController = new ApplicationController();
		applicationController.init();
		
		Application app = new Application(applicationController);

		app.setPreferredSize(new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT));
		app.setVisible(true);
		app.pack();
		app.setLocationRelativeTo(null);
	}
}
