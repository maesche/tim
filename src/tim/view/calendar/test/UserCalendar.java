package tim.view.calendar.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.Resizer;
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
	private Dimension dimension;
	
	public UserCalendar() {
		GlobalRegistry.resizer.addObserver(this);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		setLayout(flowLayout);
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
	
	public void eventSizing(){

		Dimension btnDimension;
		for(EventButton eventButton : eventButtons){
			int x, y;

			x = (int) ((eventButton.getDuration()*dimension.getWidth())/((Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START) * 60));
			y = getHeight();
			
			btnDimension = new Dimension(x, y);
			
			eventButton.setSize(btnDimension);
		    eventButton.setPreferredSize(btnDimension);
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
		if (o instanceof Resizer) {
			this.dimension = (Dimension) arg;
			System.out.println("Taille obtenue par le Resizer: " + dimension);
			repaint();
		}

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
	
	public void validate(){
		dimension = getSize();
	    setSize(dimension);
	    setPreferredSize(dimension);
	    eventSizing();
	    //System.out.println("Taille vue par validate: " + dimension);
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    validate();
	}

}
