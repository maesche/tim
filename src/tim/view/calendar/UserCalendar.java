package tim.view.calendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import sun.security.jca.GetInstance.Instance;
import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.application.utils.DateHelper;
import tim.application.utils.ErrorHandler;
import tim.controller.CalendarController;
import tim.controller.UserCalendarController;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;
import tim.view.Application;
import tim.view.dialog.appointment.AppointmentDialog;


public class UserCalendar extends JPanel{
	
	private ArrayList<EventButton> eventButtons;
	private int minutesInDay;
	private Date beginFindDate;
	private Date endFindDate;
	private AppointmentDialog eventDialog;
		
	public UserCalendar(Employee employee) throws ParseException{

		//Layout du calendrier
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(0);
		layout.setVgap(0);
		setLayout(layout);
		this.setOpaque(false);
		
		this.minutesInDay = (Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START) * 60;
		
		//Initialisation des collections
		this.eventButtons = new ArrayList<EventButton>();
		
		//Initialisation du controller
		//UserCalendarController controller = new UserCalendarController();
		CalendarController controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		//CalendarController controller = (CalendarController) this.controllers.get("CalendarController").get("action");
		
		
		Date begin = null, end = null;
		try {
			this.beginFindDate = DateHelper.StringToDate("2011-01-01", Config.DATE_FORMAT_SHORT);
			this.endFindDate = DateHelper.StringToDate("2011-06-10", Config.DATE_FORMAT_SHORT);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		//eventButtons = controller.getEventButtons(employee, beginFindDate, endFindDate);
		try {
			eventButtons = controller.getAllButtonsX(employee);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (EventButton btn : eventButtons) {
			
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					showDialog();
				}
			});
			add(btn);
		}
		
	}
	
	public void showDialog() {
		eventDialog = new AppointmentDialog(null);
		eventDialog.setModal(true);
		eventDialog.setResizable(false);
		eventDialog.pack();
		eventDialog.setLocationRelativeTo(this);
		eventDialog.setVisible(true);
	}
	
	public void eventSizing(Dimension d){

		for(EventButton btn : eventButtons){
			
			Dimension btnDimension = new Dimension((int) ((btn.getDuration()*d.getWidth())/minutesInDay), (int) d.getHeight());
			
			//il faut faire les deux op√©ration pour qu'il n'y ait pas de bug d'affichage
			btn.setSize(btnDimension);
		    btn.setPreferredSize(btnDimension);

		}
	}

	public void paintComponent(Graphics g) {
	    // Appel de la m√©thode de la classe JPanel
	    super.paintComponent(g);
	    eventSizing(new Dimension(this.getWidth(),this.getHeight()));
	}
	
	public void validate(){
		this.setSize(CalendarContainer.getCalendarDimension());
		eventSizing(new Dimension(this.getWidth(),this.getHeight()));
	}
}
