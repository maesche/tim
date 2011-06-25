/**
 * @author 
 * @version 
 */

package tim.controller;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JTable;

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
import tim.view.calendar.DayTableView;
import tim.view.calendar.DayViewContainer;
import tim.view.calendar.EventButton;

public class CalendarController extends Controller {

	private int nbrPerson;
	private int nbrHoursPerDay;
	private Date currentCalendarDate;
	private int nbrMinutesPerDay;
	private ArrayList<Employee> employees;
	
	private JTable table;
	
	private Dimension calendarSize;
	private Dimension userCalendarSize;
	private Dimension DayViewContainerPlacement;
	private Dimension DayViewContainerSize;
	
	private HashMap<String, Object> views;


	public CalendarController(){
		this.views = new HashMap<String, Object>();
		this.nbrPerson = 0;
		this.nbrHoursPerDay = Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START;
		this.nbrMinutesPerDay = (Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START) * 60;
		
		
		this.calendarSize = new Dimension();
		this.userCalendarSize = new Dimension();
		this.DayViewContainerPlacement = new Dimension();
		this.DayViewContainerSize = new Dimension();
	}
	
	//__________________________________________________________________________________
	//
	//		Method todayDay. Can occur when the "Today" button is pressed
	//__________________________________________________________________________________
	public ArrayList<Employee> todayDay() throws PersistanceException 
	{
		//---Today date
		Date dayToday = new Date();

		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		//Calendar cal = Calendar.getInstance();   
		cal.setTime(dayToday);

		//---Put it back in the Date object   
		Date begin = setupDate(cal, Config.CALENDAR_DAY_START).getTime(); 
		Date end = setupDate(cal, Config.CALENDAR_DAY_END).getTime();

		return getCalendars(begin, end);
	}

	//__________________________________________________________________________________
	//
	//		Method nextDay. Can occur when the "Next Day" button is pressed
	//__________________________________________________________________________________
	public ArrayList<Employee> nextDay(Date day) throws PersistanceException 
	{
		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();   
		cal.setTime(day);

		//---Next day = day + 1
		cal.add(GregorianCalendar.DATE, 1);

		//---Put it back in the Date object   
		Date begin = setupDate(cal, Config.CALENDAR_DAY_START).getTime(); 
		Date end = setupDate(cal, Config.CALENDAR_DAY_END).getTime();

		return getCalendars(begin, end);
	}

	//__________________________________________________________________________________
	//
	//	Method previousDay. Can occur when the "PreviousDay Day" button is pressed
	//__________________________________________________________________________________
	public ArrayList<Employee> previousDay(Date day) throws PersistanceException 
	{
		//---Get Calendar object set to the date and time of the given Date object 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();   
		cal.setTime(day);

		//---Next day = day - 1
		cal.add(GregorianCalendar.DATE, -1);

		//---Put it back in the Date object   
		Date begin = setupDate(cal, Config.CALENDAR_DAY_START).getTime(); 
		Date end = setupDate(cal, Config.CALENDAR_DAY_END).getTime();

		return getCalendars(begin, end);
	}

	//__________________________________________________________________________________
	//
	//		Method to setup the date (Hour, Minute, Second, Millisecond
	//__________________________________________________________________________________
	private GregorianCalendar setupDate(GregorianCalendar cal, int hour)
	{
		//---Set the start time of the day
		cal.set(GregorianCalendar.HOUR, hour);   
		cal.set(GregorianCalendar.MINUTE, 0);   
		cal.set(GregorianCalendar.SECOND, 0);   
		cal.set(GregorianCalendar.MILLISECOND, 0);

		return cal;
	}

	//__________________________________________________________________________________
	//
	//		Method getCalendars ; Start and End date for each Employee
	//__________________________________________________________________________________

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
		this.employees = employees;

		return employees;
	}
	
	/**
	 * 
	 * @param employee
	 * @return return the whole buttons of an employee appointments
	 * @throws PersistanceException
	 * @throws ParseException
	 */
	public ArrayList<EventButton> getButtonsCalendar(Employee employee) throws PersistanceException, ParseException{
		ArrayList<EventButton> allButtons = new ArrayList<EventButton>();
		EventButton btn = null;
		
		//ne faut-il pas faire avec equals???
		ArrayList<Appointment> appointments = employee.getCalendar().getAppointments();


		int actualMinuteOfDay = Config.CALENDAR_DAY_START*60;
		int endOfDay = Config.CALENDAR_DAY_END*60;
		int startOfButton = 0;
		int i=1;

		for (Appointment a : appointments) {

			btn = new EventButton(a);

			startOfButton = Integer.parseInt(DateHelper.DateToString(a.getBegin(), "H"))*60;

			//add invisible button
			if(startOfButton >= actualMinuteOfDay){
				String hour = String.valueOf(actualMinuteOfDay/60);
				String minutes = String.valueOf(actualMinuteOfDay%60);

				if(hour.length() <= 1){
					hour = "0" + hour;
				}
				if(minutes.length() <= 1){
					minutes = "0" + minutes;
				}

				Date begin = DateHelper.StringToDate(
						DateHelper.DateToString(a.getBegin(), Config.DATE_FORMAT_SHORT) +
						" " +
						hour +
						":" +
						minutes,

						Config.DATE_FORMAT_LONG
				);


				Date end = a.getBegin();

				EventButton invisibleButton = new EventButton(employee, begin, end);
				allButtons.add(invisibleButton);
				actualMinuteOfDay += invisibleButton.getDuration();

			}

			//add event button
			allButtons.add(btn);
			actualMinuteOfDay += btn.getDuration();

			if(i == appointments.size()){
				Date end = actualMinutesOfDayToDate(a.getBegin(),endOfDay);
				allButtons.add(new EventButton(employee, a.getEnd(), end));
			}
			i++;

		}
		
		
		// ici on ne connait pas la date actuelle du calendrier, il faut la mettre
		/*if(allButtons.size() == 0){
			Date begin = actualMinutesOfDayToDate(, actualMinuteOfDay);
			Date end = actualMinutesOfDayToDate(a.getBegin(),endOfDay);
			allButtons.add(new EventButton(employee, a.getEnd(), end));
		}*/

		return allButtons;
	}

	/*
	 * Convert
	 */
	private Date actualMinutesOfDayToDate(Date day, int minutes){
		String hour = String.valueOf(minutes/60);
		String min = String.valueOf(minutes%60);

		if(hour.length() <= 1){
			hour = "0" + hour;
		}
		if(min.length() <= 1){
			min = "0" + min;
		}

		try {
			Date date = DateHelper.StringToDate(
					DateHelper.DateToString(day, Config.DATE_FORMAT_SHORT) +
					" " +
					hour +
					":" +
					min,

					Config.DATE_FORMAT_LONG
			);
			return date;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
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

	public int getHoursPerDay(){
		return this.nbrHoursPerDay;
	}


	public ArrayList<Employee> getEmployees(){
		return this.employees;
	}
	public int getMinutesPerDay(){
		return this.nbrMinutesPerDay;
	}
	
	/**
	 * 
	 * @return
	 */
	public JTable getFormatedTable(){
		String h;
		

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();
		
		columnNames.add("Collaborateur");

		for(int i=1; i<getHoursPerDay()+1; i++){
			h = Integer.toString(i-1 + Config.CALENDAR_DAY_START);
			
			columnNames.add(h + ":00");
			System.out.println("première boucle " + i);
		}
		Vector<Object> rowData;
		int i = 0;
		for(Employee e : getEmployees()){
			rowData = new Vector<Object>();
			rowData.add(e);
			data.add(rowData);
			System.out.println("deuxième boucle " + i);
			i++;

		}
		System.out.println("Lignes " + data.size());
		this.table = new JTable(data, columnNames);
		return table;
	}
	
	
	
	
	
	public void addView(String viewName,Object view){
		this.views.put(viewName, view);
	}
	public Object getViews(String viewName){
		return this.views.get(viewName);
	}
	
	
	
	
	
	
	
	
	
	public Dimension getCalendarSize() {
		return calendarSize;
	}
	public Dimension getDayViewContainerPlacement() {
		return DayViewContainerPlacement;
	}
	public Dimension getDayViewContainerSize() {
		return DayViewContainerSize;
	}

	public void updateCalendarDimension(){
		DayViewContainer dayViewContainer = (DayViewContainer) this.getViews("DayViewContainer");
		DayTableView dayTableView = (DayTableView) this.getViews("DayTableView");
		
		this.calendarSize.setSize(dayViewContainer.getWidth(),dayViewContainer.getHeight());
		
		this.DayViewContainerPlacement.setSize((int)dayTableView.table.getColumnModel().getColumn(0).getWidth(), 20);
		
		this.DayViewContainerSize.setSize((int)dayTableView.getWidth()-(int)dayTableView.table.getColumnModel().getColumn(0).getWidth(), (int)dayTableView.getHeight()-20);
	}



	
	
	
	
	
	
	
	
	
	
	
	

}
