import java.util.ArrayList;

import tim.calendar.AppointmentHandler;
import tim.calendar.Appointment;
import tim.calendar.TimeTable;
import tim.application.DateHelper;


public class TIMTest {
	public static void main(String[] args) {
		AppointmentHandler appHandler = new AppointmentHandler();
		ArrayList<Appointment> appointments = appHandler.getElements();	
		
		for(Appointment appointment : appointments) {
			System.out.println(appointment);
		}
		/*
		ArrayList<TimeTable> timeTables = new ArrayList<TimeTable>();
		
		Appointment appointment = new Appointment();
		
		timeTables.add(new TimeTable(DateHelper.StringToDate("2011-06-15 13:45"), DateHelper.StringToDate("2011-06-15 14:45")));
		
		appHandler.add(appointment, timeTables);
		
		System.out.println("------------------------");
		for(Appointment appointment : appointments) {
			System.out.println(appointment);
		}*/
		
	}
}
