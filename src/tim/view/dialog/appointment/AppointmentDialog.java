package tim.view.dialog.appointment;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDialog;

import tim.controller.AppointmentDialogController;
import tim.model.Appointment;
import tim.model.Client;
import tim.model.Employee;
import tim.view.Application;

public class AppointmentDialog extends JDialog implements ActionListener {
	Appointment appointment = null;
	Form form = null;

	public AppointmentDialog(Appointment apointment) {
		System.out.println(appointment);
		this.appointment = appointment;

		/*
		 * Only for testing we create the model at this place
		 */
		AppointmentDialogController controller = new AppointmentDialogController();
		
		form = new Form(controller);



		setTitle("TIM - Appointment");
		Container cb = getContentPane();
		cb.add(form);
	}
	
	public AppointmentDialog (Employee employee, Date begin, Date end) {
		System.out.println(employee + " " + begin + " " + end);
	}

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}

}
