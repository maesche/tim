package tim.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.model.AbstractModel;
import tim.model.Appointment;
import tim.model.Client;
import tim.model.ClientModel;
import tim.model.Element;
import tim.model.Employee;
import tim.model.EmployeeModel;
import tim.model.AppointmentModel;


public class AppointmentDialogController extends Controller {	
	public boolean checkAvailability(Appointment appointment) throws PersistanceException, ParseException {
		boolean canInsert = true;

		Date begin =  null;
		Date end = null;
		
		
		begin =  DateHelper.StringToDate(DateHelper.DateToString(appointment.getBegin()) + " " + Config.CALENDAR_DAY_START + ":00", Config.DATE_FORMAT_LONG);
		end = DateHelper.StringToDate(DateHelper.DateToString(appointment.getEnd()) + " " + Config.CALENDAR_DAY_END + ":00", Config.DATE_FORMAT_LONG);
		
		AppointmentModel appointmentModel = (AppointmentModel) models.get("AppointmentModel");
		
		
		ArrayList<Element> appointments = (ArrayList<Element>)appointmentModel.get((Employee)appointment.getEmployee(), begin, end);
		
		for (Element element : appointments) {
			Appointment app = (Appointment) element;
			
			Date a_begin = app.getBegin();
			Date a_end = app.getEnd();

			canInsert = appointment.getId() == element.getId() || (appointment.getEnd().before(a_begin) || appointment.getEnd().equals(a_begin)) || (appointment.getBegin().after(a_end) || appointment.getBegin().equals(a_end));
		}
		
		return canInsert;
	}
}
