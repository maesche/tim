package tim.view.calendar.test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;

import tim.application.exception.PersistanceException;
import tim.model.Appointment;
import tim.model.Employee;
import tim.view.ChildView;
import tim.view.ParentView;
import tim.view.calendar.test.EventButton;
import tim.view.dialog.appointment.AppointmentDialog;

public class UserCalendar extends JPanel implements ChildView {

	private ArrayList<EventButton> eventButtons;
	private ArrayList<Appointment> appointments;
	private AppointmentDialog appointmentDialog;
	private ParentView parentView;
	
	public UserCalendar() {
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(0);
		layout.setVgap(0);
		setLayout(layout);
		setOpaque(false);
	}
	
	public void load() {
		eventButtons = (ArrayList<EventButton>) ((CalendarContainer) parentView).getButtonsForCalendar(appointments);

		
		for (EventButton eventButton : eventButtons) {
			final Appointment appointment = eventButton.getAppointment();
			eventButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showDialog(appointment);
				}
			});
			add(eventButton);
		}
	}
	
	public void showDialog(Appointment appointment) {
		appointmentDialog = new AppointmentDialog(appointment);
		appointmentDialog.setModal(true);
		appointmentDialog.setResizable(false);
		appointmentDialog.pack();
		appointmentDialog.setLocationRelativeTo(this);
		appointmentDialog.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParentView(ParentView view) {
		this.parentView = view;
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(Object value) {
		Employee employee = (Employee) value;
		appointments = employee.getCalendar().getAppointments();

	}

}
