package tim.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;
import tim.view.calendar.EventButton;

public class UserCalendarController extends AbstractController {
	
	public ArrayList<Element> getEmployeeEvents(Employee employee, Date begin, Date end) throws PersistanceException{
		return ((AppointmentModel) this.models.get("AppointmentModel")).get(employee, begin, end);
	}
	
	
	/*public ArrayList<EventButton> getEventButtons(Element employee, Date begin, Date end) throws PersistanceException{
		ArrayList<EventButton> eventButtons = null;
		
		if (begin != null && end != null) {
			ArrayList<Employee> appointments = ((AppointmentModel) this.models.get("AppointmentModel")).get(employee, begin, end);
			
			
			eventButtons = new ArrayList<EventButton>();
			for (Element element : appointments) {
				Appointment a = (Appointment) element;
				eventButtons.add(new EventButton(a));
				//eventButtons.add(new EventButton(180));
			}
		}
		
		return eventButtons;
	}*/
	
	/*public ArrayList<EventButton> getAllButtons(ArrayList<EventButton> visibleButtons){
		ArrayList<EventButton> allButtons = new ArrayList<EventButton>();
		EventButton actualButton;
		boolean exit = false;
		int i = 0;
		int startOfButton = 0;
		int nbrVisibleButtons = visibleButtons.size();
		
		int actualMinuteOfDay = Config.CALENDAR_DAY_START*60;
		int endOfDay = Config.CALENDAR_DAY_END*60;
		
		while(i < nbrVisibleButtons+1 && exit == false){
			if(i == nbrVisibleButtons){
				actualButton = null;
			}else{
				actualButton = visibleButtons.get(i);
				startOfButton = Integer.parseInt(DateHelper.DateToString(actualButton.getBegin(), "H"))*60;
			}
			
			
			if(actualButton != null){//encore des evenements pour l'utilisateur
				if(actualMinuteOfDay < startOfButton){
					allButtons.add(new EventButton(startOfButton - actualMinuteOfDay));
					actualMinuteOfDay += startOfButton - actualMinuteOfDay;
				}else if(actualMinuteOfDay == startOfButton){
					allButtons.add(visibleButtons.get(i));
					actualMinuteOfDay += visibleButtons.get(i).getDuration();
					i++;
				}
			}else{//Plus d'événements pour l'utilisateur
				if(actualMinuteOfDay < endOfDay){
					allButtons.add(new EventButton(endOfDay - actualMinuteOfDay));
					exit = true;
				}else{
					
				}
			}			
		}

		return allButtons;
	}*/
	
	
	public int getEventDuration(Date begin, Date end){
		return DateHelper.DateDiff(begin, end);
	}
	
	public String getEventTitle(Appointment a){
		String title;
		title = "<html>";
		title += DateHelper.DateToString(a.getBegin(),
				Config.TIME_FORMAT)
				+ " - "
				+ DateHelper.DateToString(a.getEnd(),
						Config.TIME_FORMAT) + "<br />";
		title += "with " + a.getClient().getFirstName() + " "
				+ a.getClient().getLastName() + "<br />";
		title += a.getDescription() + "<br />";
		title += "durée: " + String.valueOf(getEventDuration(a.getBegin(),a.getEnd())) + "<br />";

		title += "</html>";

		return title;
	}


	@Override
	public Element get(String action) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Element> getAll(String action) throws PersistanceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(String action, Element element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveAll(String action, ArrayList<Element> element) {
		// TODO Auto-generated method stub
		
	}
}
