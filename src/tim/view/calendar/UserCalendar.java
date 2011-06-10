package tim.view.calendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import sun.security.jca.GetInstance.Instance;
import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.application.utils.ErrorHandler;
import tim.controller.UserCalendarController;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;


public class UserCalendar extends JPanel{
	
	private ArrayList<EventButton> eventButtons;
	private int minutesInDay;
		
	public UserCalendar(Employee employee, Color userColor){
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
		UserCalendarController controller = new UserCalendarController();
		controller.addModel(new AppointmentModel());

		
		Date begin = null, end = null;
		try {
			begin = DateHelper.StringToDate("2011-01-01", Config.DATE_FORMAT_SHORT);
			end = DateHelper.StringToDate("2011-06-10", Config.DATE_FORMAT_SHORT);
		} catch (ParseException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "constructor");
		}
		if (begin != null && end != null) {
			ArrayList<Element> appointments = controller.getEmployeeEvents(employee, begin, end);

			for (Element element : appointments) {
				this.eventButtons.add(new EventButton((Appointment) element, userColor));
			}
			
			for (EventButton btn : eventButtons) {
				add(btn);
			}
		}
        
        /*
        btn2.setBorderPainted(false);
        btn2.setBackground(new Color(1f,1f,1f,0));
        btn2.setOpaque(false);
        */
		
	}
	
	public void eventSizing(Dimension d){

		for(EventButton btn : eventButtons){
			
			Dimension btnDimension = new Dimension((int) (btn.getDuration()*d.getWidth()/minutesInDay), (int) d.getHeight());
			
			//il faut faire les deux opération pour qu'il n'y ait pas de bug d'affichage
			btn.setSize(btnDimension);
		    btn.setPreferredSize(btnDimension);
		}
	}

	public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    
	    eventSizing(new Dimension(this.getWidth(),this.getHeight()));
	    
	}

	
}
