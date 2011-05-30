package tim.view.eventdialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import tim.view.Application;

public class EventDialog extends JDialog implements ActionListener {
	Application application;

	public EventDialog(Application app) {
		this.application = app;

		setTitle("TIM - Appointment");
		Container cb = getContentPane();
		cb.add(new Form());

	}

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}

}
