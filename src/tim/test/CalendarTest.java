package tim.test;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import tim.application.BootLoader;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.controller.CalendarController;
import tim.model.Employee;


public class CalendarTest {

	public static void main(String[] args) {
		try {
			BootLoader.init(System.getProperty("user.dir") + "/config/application.xml");
		} catch (PersistanceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		CalendarController calendarController = new CalendarController();

		
		Date begin = null;
		try {
			begin = DateHelper.StringToDate("2011-05-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = null;
		try {
			end = DateHelper.StringToDate("2011-06-15");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Employee> employees = null;
		try {
			employees = calendarController.getCalendars(begin, end);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Employee employee : employees) {
			System.out.println(employee.getCalendar().getAppointments().get(0));
		}
	}

}
