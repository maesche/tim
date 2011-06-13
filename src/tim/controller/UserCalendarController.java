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
				eventButtons.add(new EventButton(this.getEventTitle(a), a.getBegin(), a.getEnd(), this.getEventDuration(a.getBegin(),a.getEnd()), new Color(255,0,0,100)));
				//eventButtons.add(new EventButton(180));
			}
		}
		
		return eventButtons;
	}
	
	public ArrayList<EventButton> getAllButtons(ArrayList<EventButton> visibleButtons){
		ArrayList<EventButton> allButtons = new ArrayList<EventButton>();
		
		/*int actualMinuteOfDay = Config.CALENDAR_DAY_START*60;
		
		int startOfButton = 0;
		
		System.out.println("NOUVEAU");
		for(EventButton btn : visibleButtons){
			startOfButton = getEventButtonStartAt(btn);
			//startOfButton = 600;
			
			if(actualMinuteOfDay < startOfButton){
				allButtons.add(new EventButton(startOfButton - actualMinuteOfDay));
				System.out.println("ajoute vide");
				actualMinuteOfDay += startOfButton - actualMinuteOfDay;
			}else if(actualMinuteOfDay == startOfButton){
				allButtons.add(btn);
				actualMinuteOfDay += btn.getDuration();
				System.out.println("ajoute event");
			}else{
				System.out.println("erreur");
			}
			
		}*/
		
		allButtons.add(new EventButton(60));
		allButtons.add(visibleButtons.get(0));
		allButtons.add(new EventButton(60));
		allButtons.add(visibleButtons.get(1));

		return allButtons;
	}
	
	private int getEventButtonStartAt(EventButton btn){
		//String hourString = DateHelper.DateToString(btn.getBegin(), "HH");
		//return (btn.getBegin().getHours()*60) + (btn.getBegin().getMinutes());
		return 540;
		//return Integer.parseInt(hourString)*60;
	}
	
	
	public int getEventDuration(Date begin, Date end){
		return DateHelper.DateDiff(begin, end);
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
		title += "durée: " + String.valueOf(getEventDuration(a.getBegin(),a.getEnd())) + "<br />";

		title += "</html>";

		return title;
	}
}
