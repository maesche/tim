package tim.controller;

import java.awt.Dimension;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.application.utils.ErrorHandler;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;
import tim.view.calendar.EventButton;

public class UserCalendarController extends AbstractController {
	
	/*private ArrayList<Appointment> appointments = null;
	
	public UserCalendarController() {
		appointments = new ArrayList<Appointment>();
		
	}
	
	private ArrayList<Element> getEmployeeEvents(Employee employee, String sBegin, String sEnd){
		
		Date begin = null, end = null;
		try {
			begin = DateHelper.StringToDate(sBegin, Config.DATE_FORMAT_SHORT);
			end = DateHelper.StringToDate(sEnd, Config.DATE_FORMAT_SHORT);
		} catch (ParseException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "getEmployeeEvents");
		}
		if (begin != null && end != null) {
			return ((AppointmentModel) models.get("AppointmentModel")).get(employee, begin, end);
		}else{
			return null;
		}
	}*/
	
	public ArrayList<EventButton> getEventButtons(Employee employee, String sBegin, String sEnd){
		ArrayList<Element> appointments = null;
		ArrayList<EventButton> eventButtons = new ArrayList<EventButton>();
		
		Date begin = null, end = null;
		try {
			begin = DateHelper.StringToDate(sBegin, Config.DATE_FORMAT_SHORT);
			end = DateHelper.StringToDate(sEnd, Config.DATE_FORMAT_SHORT);
		} catch (ParseException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "getEmployeeEvents");
		}
		
		if (begin != null && end != null) {
			appointments = models.get("AppointmentModel").get();
			
			for (Element element : appointments) {
				Appointment test = (Appointment) element;
				System.out.println(test.getTitle());
				
				EventButton eventButton = new EventButton((Appointment) element);
				eventButton.toString();
				

				eventButtons.add(eventButton);
			}
			
			
		}
		
		
		return eventButtons;
		
	}
	
}
