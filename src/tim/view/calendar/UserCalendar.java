package tim.view.calendar;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JPanel;

import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.controller.CalendarController;
import tim.model.Appointment;
import tim.model.Employee;
import tim.view.dialog.appointment.AppointmentDialog;


public class UserCalendar extends JPanel{
	
	private ArrayList<EventButton> eventButtons;
	private AppointmentDialog eventDialog;
	
	
	CalendarController controller;
		
	public UserCalendar(Employee employee){

		//Layout du calendrier
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(0);
		layout.setVgap(0);
		setLayout(layout);
		this.setOpaque(false);
		
		//Initialisation des collections
		this.eventButtons = new ArrayList<EventButton>();
		
		//Initialisation du controller
		this.controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		

		try {
			eventButtons = controller.getButtonsCalendar(employee);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (final EventButton btn : eventButtons) {
			
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showDialog(btn.getAppointment());
				}
			});
			add(btn);
		}

	}
	
	public void showDialog(Appointment appointment) {
		eventDialog = new AppointmentDialog(appointment);
		eventDialog.setModal(true);
		eventDialog.setResizable(false);
		eventDialog.pack();
		eventDialog.setLocationRelativeTo(this);
		eventDialog.setVisible(true);
	}
	
	public void eventSizing(){

		for(EventButton btn : eventButtons){
			int x,y;
			this.controller.updateCalendarDimension();
			/*x = (int) ((btn.getDuration()*calendarDimension.getWidth())/this.controller.getMinutesPerDay());
			y = (int) calendarDimension.getHeight();*/
			x = (int) ((btn.getDuration()*controller.getCalendarSize().getWidth())/this.controller.getMinutesPerDay());
			y = this.getHeight();
			
			Dimension btnDimension = new Dimension(x , y);
			
			//It must be setSize and setPreferredSize for this button, Otherwise the button is misplaced
			btn.setSize(btnDimension);
		    btn.setPreferredSize(btnDimension);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
	    // Appel de la m√©thode de la classe JPanel
	    super.paintComponent(g);
	    eventSizing();
	    System.out.println("        " + this.getWidth() + " " + this.getHeight());
	}
	
	@Override
	public void validate(){
		//this.setSize(this.controller.getDayViewContainerSize());
		this.controller.updateCalendarDimension();
		System.out.println("        " + this.getWidth() + " " + this.getHeight());
		eventSizing();
		
		
		
		
		//this.controller.setUserCalendarSize(this.getWidth(), this.getHeight());
	}
}
