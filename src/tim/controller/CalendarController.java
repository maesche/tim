package tim.controller;

import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.utils.DateHelper;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Calendar;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;
import tim.view.calendar.EventButton;

public class CalendarController extends AbstractController {

	public ArrayList<Employee> today() {
		int Hstart = Config.CALENDAR_DAY_START;
		int Hend = Config.CALENDAR_DAY_END;
		
		Date today = null;
		
		Date begin = null; //today + heure début
		Date end = null; //today + heure fin
		
		return getCalendars(begin, end);
	}
	
	public ArrayList<Employee> getCalendars(Date begin, Date end) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Appointment> appointments;
		EmployeeModel employeeModel = (EmployeeModel) this.models.get("EmployeeModel");
		AppointmentModel appointmentModel = (AppointmentModel) this.models.get("AppointmentModel");
		
		
		for (Element element: employeeModel.get()) {
			Employee employee = (Employee) element;
			Calendar calendar = employee.getCalendar();
			
			
			appointments = new ArrayList<Appointment>();
			
			
			ArrayList<Element> elements = appointmentModel.get(employee, begin, end);
			
			for (Element el : elements) {
				Appointment appointment = (Appointment) el;
				appointments.add(appointment);
			}

			calendar.setAppointments(appointments);

			employee.setCalendar(calendar);
			
			employees.add(employee);
		}
		
		return employees;
	}
	
	public ArrayList<EventButton> getEventButtons(Employee employee, Date begin, Date end){
		ArrayList<EventButton> eventButtons = null;
		
		if (begin != null && end != null) {
			ArrayList<Element> appointments = ((AppointmentModel) this.models.get("AppointmentModel")).get(employee, begin, end);
			
			
			eventButtons = new ArrayList<EventButton>();
			for (Element element : appointments) {
				Appointment a = (Appointment) element;
				eventButtons.add(new EventButton(this.getEventTitle(a), a.getBegin(), a.getEnd(), this.getEventDuration(a.getBegin(),a.getEnd()), employee.getColor()));
				//eventButtons.add(new EventButton(180));
			}
		}
		
		return eventButtons;
	}
	
	public ArrayList<EventButton> getAllButtons(ArrayList<EventButton> visibleButtons){
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
	}
	
	
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
	
}
