package tim.view.calendar.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import tim.application.Config;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.controller.Controller;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Calendar;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;
import tim.view.calendar.test.EventButton;

public class CalendarController extends Controller {
	
	// __________________________________________________________________________________
	//
	// Method getCalendars ; Start and End date for each Employee
	// __________________________________________________________________________________

	public ArrayList<Element> getCalendars(Date begin, Date end)
			throws PersistanceException {
		ArrayList<Element> employees = new ArrayList<Element>();

		EmployeeModel employeeModel = (EmployeeModel) this.models
				.get("EmployeeModel");


		for (Element element : employeeModel.get()) {
			Employee employee = (Employee) element;
			
			employee = getCalendar(employee, begin, end);

			employees.add(employee);
		}

		return employees;
	}
	
	private Employee getCalendar(Employee employee, Date begin, Date end) throws PersistanceException {
		ArrayList<Appointment> appointments;
		AppointmentModel appointmentModel = (AppointmentModel) this.models
		.get("AppointmentModel");
		Calendar calendar = employee.getCalendar();
		appointments = new ArrayList<Appointment>();

		ArrayList<Element> elements = appointmentModel.get(employee, begin,
				end);

		for (Element el : elements) {
			Appointment appointment = (Appointment) el;
			appointments.add(appointment);
		}

		calendar.setAppointments(appointments);

		employee.setCalendar(calendar);
		
		return employee;
	}

	/**
	 * 
	 * @param employee
	 * @return return the whole buttons of an employee appointments
	 * @throws PersistanceException
	 * @throws ParseException
	 */
	/*public ArrayList<EventButton> getButtonsCalendar(ArrayList<Appointment> appointments)throws PersistanceException, ParseException {
		ArrayList<EventButton> eventButtons = new ArrayList<EventButton>();
		EventButton eventButton = null;

		int actualMinuteOfDay = Config.CALENDAR_DAY_START * 60;
		int endOfDay = Config.CALENDAR_DAY_END * 60;
		int beginOfDay = Config.CALENDAR_DAY_START*60;
		int startOfButton = 0;
		int i = 1;

		for (Appointment appointment : appointments) {
			Employee employee = (Employee) appointment.getEmployee();
			eventButton = new EventButton(appointment);

			startOfButton = Integer.parseInt(DateHelper.DateToString(
					appointment.getBegin(), "H")) * 60;

			// add invisible button
			if (startOfButton >= actualMinuteOfDay) {
				String hour = String.valueOf(actualMinuteOfDay / 60);
				String minutes = String.valueOf(actualMinuteOfDay % 60);

				if (hour.length() <= 1) {
					hour = "0" + hour;
				}
				if (minutes.length() <= 1) {
					minutes = "0" + minutes;
				}

				Date begin = DateHelper.StringToDate(
						DateHelper.DateToString(appointment.getBegin(),
								Config.DATE_FORMAT_SHORT)
								+ " "
								+ hour
								+ ":"
								+ minutes,

						Config.DATE_FORMAT_LONG);

				Date end = appointment.getBegin();

				EventButton invisibleButton = new EventButton(employee, begin,
						end);
				eventButtons.add(invisibleButton);
				actualMinuteOfDay += invisibleButton.getDuration();

			}

			// add event button
			eventButtons.add(eventButton);
			actualMinuteOfDay += eventButton.getDuration();
			
			//on est au dernier élément donc on ajoute le dernier bouton invisible
			if (i == appointments.size()) {
				Date end = actualMinutesOfDayToDate(appointment.getBegin(),
						endOfDay);
				eventButtons.add(new EventButton(employee,
						appointment.getEnd(), end));
			}
			i++;

		}
		
		//Si le calendrier n'a pas d'événement on ajout un événement invisible
		if(i == 1){
			//faitre dernier bouton
			Date begin = actualMinutesOfDayToDate(date, beginOfDay);
			Date end = actualMinutesOfDayToDate(date, endOfDay);
			
			eventButtons.add(new EventButton(employee,begin, end));
		}
		
		return eventButtons;
	}*/

	private Date actualMinutesOfDayToDate(Date day, int minutes) {
		String hour = String.valueOf(minutes / 60);
		String min = String.valueOf(minutes % 60);

		if (hour.length() <= 1) {
			hour = "0" + hour;
		}
		if (min.length() <= 1) {
			min = "0" + min;
		}

		try {
			Date date = DateHelper.StringToDate(
					DateHelper.DateToString(day, Config.DATE_FORMAT_SHORT)
							+ " " + hour + ":" + min,

					Config.DATE_FORMAT_LONG);
			return date;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<EventButton> getButtonsCalendar(ArrayList<Appointment> appointments)throws PersistanceException, ParseException {
		ArrayList<EventButton> eventButtons = new ArrayList<EventButton>();
		EventButton eventButton = null;

		int actualMinuteOfDay = Config.CALENDAR_DAY_START * 60;
		int endOfDay = Config.CALENDAR_DAY_END * 60;
		int beginOfDay = Config.CALENDAR_DAY_START*60;
		int startOfButton = 0;
		int i = 1;

		for (Appointment appointment : appointments) {
			Employee employee = (Employee) appointment.getEmployee();
			eventButton = new EventButton(appointment);

			startOfButton = Integer.parseInt(DateHelper.DateToString(
					appointment.getBegin(), "H")) * 60;

			// add invisible button
			if (startOfButton >= actualMinuteOfDay) {
				String hour = String.valueOf(actualMinuteOfDay / 60);
				String minutes = String.valueOf(actualMinuteOfDay % 60);

				if (hour.length() <= 1) {
					hour = "0" + hour;
				}
				if (minutes.length() <= 1) {
					minutes = "0" + minutes;
				}

				Date begin = DateHelper.StringToDate(
						DateHelper.DateToString(appointment.getBegin(),
								Config.DATE_FORMAT_SHORT)
								+ " "
								+ hour
								+ ":"
								+ minutes,

						Config.DATE_FORMAT_LONG);

				Date end = appointment.getBegin();

				EventButton invisibleButton = new EventButton(employee, begin,
						end);
				eventButtons.add(invisibleButton);
				actualMinuteOfDay += invisibleButton.getDuration();

			}

			// add event button
			eventButtons.add(eventButton);
			actualMinuteOfDay += eventButton.getDuration();
			
			//on est au dernier élément donc on ajoute le dernier bouton invisible
			if (i == appointments.size()) {
				Date end = actualMinutesOfDayToDate(appointment.getBegin(),
						endOfDay);
				eventButtons.add(new EventButton(employee,
						appointment.getEnd(), end));
			}
			i++;

		}
		
		//Si le calendrier n'a pas d'événement on ajout un événement invisible
		if(i == 1){
			//faitre dernier bouton
			Date begin = actualMinutesOfDayToDate(today, beginOfDay);
			Date end = actualMinutesOfDayToDate(today, endOfDay);
			
			eventButtons.add(new EventButton(employee,begin, end));
		}
		
		return eventButtons;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
