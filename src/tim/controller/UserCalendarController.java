package tim.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;
import tim.view.calendar.EventButton;

public class UserCalendarController extends AbstractController {
	
	public ArrayList<Element> getEmployeeEvents(Employee employee, Date begin, Date end){
		return ((AppointmentModel) models.get("AppointmentModel")).get(employee, begin, end);
	}
	
	
	public ArrayList<EventButton> getEventButtons(Employee employee, Date begin, Date end){
		ArrayList<EventButton> eventButtons = null;
		
		if (begin != null && end != null) {
			ArrayList<Element> appointments = ((AppointmentModel) models.get("AppointmentModel")).get(employee, begin, end);
			
			
			eventButtons = new ArrayList<EventButton>();
			for (Element element : appointments) {
				Appointment a = (Appointment) element;
				eventButtons.add(new EventButton(a.getTitle(), this.getEventDuration(a), new Color(255,0,0,100)));
			}
		}
		
		
		return eventButtons;
	}
	
	
	public int getEventDuration(Appointment a){
		return DateHelper.DateDiff(a.getBegin(), a.getEnd());
	}
	
	public String getEventTitle(Appointment a){
		String title;
		title = "<html>";
		title += DateHelper.DateToString(a.getBegin(),
				Config.DATE_FORMAT_EVENT_HOUR)
				+ " - "
				+ DateHelper.DateToString(a.getEnd(),
						Config.DATE_FORMAT_EVENT_HOUR) + "<br />";
		title += a.getTitle() + "<br />";
		title += "with " + a.getClient().getFirstName() + " "
				+ a.getClient().getLastName() + "<br />";
		title += a.getDescription() + "<br />";
		title += "durée: " + String.valueOf(getEventDuration(a)) + "<br />";

		title += "</html>";

		return title;
	}
}
