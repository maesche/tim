import java.util.ArrayList;

import tim.calendar.AppointmentHandler;
import tim.calendar.Appointment;


public class TIMTest {
	public static void main(String[] args) {
		AppointmentHandler appHandler = new AppointmentHandler();
		ArrayList<Appointment> appointments = appHandler.getElements();	
		
		for(Appointment appointment : appointments) {
			System.out.println(appointment);
		}
	}
}
