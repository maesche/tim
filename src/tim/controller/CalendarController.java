package tim.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Calendar;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;
import tim.view.Application;
import tim.view.calendar.EventButton;

public class CalendarController extends AbstractController {
	
	private int nbrPerson;
	private int nbrHourPerDay;
	private Date currentCalendarDate;

	
	public CalendarController(){
		this.nbrPerson = 0;
		this.nbrHourPerDay = Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START;
	}

	public ArrayList<Employee> today() throws PersistanceException {
		int Hstart = Config.CALENDAR_DAY_START;
		int Hend = Config.CALENDAR_DAY_END;
		
		Date today = null;
		
		
		
		Date begin = null; //today + heure début
		Date end = null; //today + heure fin
		
		return getCalendars(begin, end);
	}
	
	public ArrayList<Employee> getCalendars(Date begin, Date end) throws PersistanceException {
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
		
		this.nbrPerson = employees.size();
		
		return employees;
	}
	
	/*public ArrayList<EventButton> getEventButtons(Employee employee, Date begin, Date end) throws PersistanceException{
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
	}*/
	
	/*public ArrayList<EventButton> getAllButtons(ArrayList<EventButton> visibleButtons){
		ArrayList<EventButton> allButtons = new ArrayList<EventButton>();
		
		ArrayList<Employee> getCalendars(begin, end);
		
		
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
	
	public ArrayList<EventButton> getAllButtonsX(Employee employee) throws PersistanceException, ParseException{
		ArrayList<EventButton> allButtons = new ArrayList<EventButton>();
		EventButton btn = null;
		
		ArrayList<Appointment> appointments = employee.getCalendar().getAppointments();
		
		
		int actualMinuteOfDay = Config.CALENDAR_DAY_START*60;
		int endOfDay = Config.CALENDAR_DAY_END*60;
		int startOfButton = 0;
		System.out.println("Deb-------------");
		for (Appointment a : appointments) {
			
			btn = new EventButton(a);
			
			startOfButton = Integer.parseInt(DateHelper.DateToString(a.getBegin(), "H"))*60;
			
			//add invisible button
			if(startOfButton >= actualMinuteOfDay){
				String msg = "vide " + actualMinuteOfDay + " -> ";
				String hour = String.valueOf(actualMinuteOfDay/60);
				String minutes = String.valueOf(actualMinuteOfDay%60);
				
				if(hour.length() <= 1){
					hour = "0" + hour;
				}
				if(minutes.length() <= 1){
					minutes = "0" + minutes;
				}
				
				//System.out.println(DateHelper.StringToDate(DateHelper.DateToString(a.getBegin(), Config.DATE_FORMAT_SHORT) + " " + hour + ":" + minutes));
				
				Date begin = DateHelper.StringToDate(
						DateHelper.DateToString(a.getBegin(), Config.DATE_FORMAT_SHORT) +
						" " +
						hour +
						":" +
						minutes,
						
						"yyyy-MM-dd HH:mm"
				);
				
				
				Date end = a.getBegin();
				
				System.out.println(begin.toString() + " ----- "+ end.toString());
				//System.out.println(DateHelper.DateDiff(a.getBegin(), a.getEnd()));
				//System.out.println(DateHelper.DateDiff(begin, end));
				
				EventButton invisibleButton = new EventButton(employee, begin, end);
				allButtons.add(invisibleButton);
				actualMinuteOfDay += invisibleButton.getDuration();
				msg += actualMinuteOfDay;
				
				//System.out.println(msg);
				
			}
			
			//add event button
			allButtons.add(btn);
			//System.out.println("Ajout bouton " + actualMinuteOfDay);
			actualMinuteOfDay += btn.getDuration();
		}
		
		//add last invisible button
		if(actualMinuteOfDay < endOfDay){
			//System.out.println("videFin " + actualMinuteOfDay + " et fin " + endOfDay);
		}
		
		System.out.println("Fin-------------");
		return allButtons;
	}
	
	
	public int getEventDuration(Date begin, Date end){
		return DateHelper.DateDiff(begin, end);
	}
	
	public String getEventTitle(Appointment a){
		String title;
		title = "<html>";
		title += DateHelper.DateToString(a.getBegin(),Config.TIME_FORMAT)
				+ " - "
				+ DateHelper.DateToString(a.getEnd(), Config.TIME_FORMAT) + "<br />";
		title += a.getClient().getFirstName() + " "
				+ a.getClient().getLastName() + "<br />";
		title += "</html>";

		return title;
	}
	
	
	public int getNbrPerson(){
		return this.nbrPerson;
	}
	
}
