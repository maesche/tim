package tim.view.appointmentdialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import tim.controller.AppointmentController;
import tim.model.AppointmentModel;
import tim.view.Application;

public class AppointmentDialog extends JDialog implements ActionListener {
	Application application;

	public AppointmentDialog(Application app) {
		this.application = app;
		/*
		 * Only for testing we create the model at this place
		 */
		AppointmentController controller = new AppointmentController();
		controller.addModel(new AppointmentModel());

		setTitle("TIM - Appointment");
		Container cb = getContentPane();
		cb.add(new Form(controller));

	}

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}

}
