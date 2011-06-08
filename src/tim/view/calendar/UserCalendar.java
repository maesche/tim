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
				this.eventButtons.add(new EventButton((Appointment) element));
			}
			
			for (EventButton btn : eventButtons) {
				add(btn);
			}
		}
		
		
		
		

		//ajout des boutons
		/*btn1.setSize(100,this.getHeight());
		btn1.setText("<html>" + employee + "</html>");
	    btn2.setSize(200,this.getHeight());
	    btn2.setText("<html>" + employee + "</html>");
	    btn3.setSize(300,this.getHeight());
	    btn3.setText("<html>" + employee + "</html>");
        add(btn1);
        add(btn2);
        add(btn3);*/
        //add(btn4);
        
        
        
        
        
        
        /*btn1.setPreferredSize(new Dimension(100,50));
        
        btn2.setPreferredSize(new Dimension(250,50));
        btn2.setBorderPainted(false);
        btn2.setBackground(new Color(1f,1f,1f,0));
        btn2.setOpaque(false);
        
        btn2.setText("");
        */
        
        
        //btn3.setMargin(new Insets(0, 0, 0, 0));
		
	}
	
	public void eventSizing(Dimension d){
		for(EventButton btn : eventButtons){
			btn.setSize(new Dimension(100,(int) d.getHeight()));
		    btn.setPreferredSize(new Dimension(100,(int) d.getHeight()));
		}
	}

	public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    
	    eventSizing(new Dimension(this.getWidth(),this.getHeight()));
	    
	    
	    
	    /*btn1.setSize(100,this.getHeight());
	    btn1.setPreferredSize(new Dimension(100,200));
	    
	    btn2.setSize(200,this.getHeight());
	    btn2.setText("");
	    btn2.setPreferredSize(new Dimension(200,200));
	    btn2.setBorderPainted(false);
        btn2.setBackground(new Color(1f,1f,1f,0));
        btn2.setOpaque(false);
        
	    btn3.setSize(300,this.getHeight());
	    //btn3.setBackground(new Color(1, 1, 1, 0));
	    btn3.setPreferredSize(new Dimension(300,200));*/
	    
	    
	    
	    
	    //this.calendarWidth = this.getWidth();
	    //this.calendarHeight = this.getHeight();
	    //System.out.println(this.getWidth() + "x" + this.getHeight());
	    //System.out.println(this.getWidth() + "x" + this.getHeight());
	    
	    
	    /*this.btn3.setSize(100, this.calendarHeight);
	    this.btn1.setSize(100, this.calendarHeight);
	    System.out.println(btn3.getPreferredSize().getHeight());
	    System.out.println("----------------");*/
	}

	
}
