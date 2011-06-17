package tim.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import tim.application.BootLoader;
import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.application.utils.ErrorHandler;
import tim.model.AbstractModel;
import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;

public class ApplicationController extends AbstractController {
	
	public void init() {
		String xmlFilePath = Config.CONFIG_PATH + "xml/application.xml";
		BootLoader bootLoader = new BootLoader(xmlFilePath);
		bootLoader.loadConfig();
		
	}

	public void getTest() {
		AppointmentModel appointmentModel = (AppointmentModel) this.models.get("AppointmentModel");
		/*
		 * getElements test
		 */
		Date begin = null, end = null;
		try {
			begin = DateHelper.StringToDate("2011-05-13 8:45", Config.DATE_FORMAT_LONG);
			end = DateHelper.StringToDate("2011-07-17 11:45", Config.DATE_FORMAT_LONG);
		} catch (ParseException ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "getTest");
		}
		if (begin != null && end != null) {
			ArrayList<Element> appointments = appointmentModel.get(begin, end);

			for (Element element : appointments) {
				Appointment appointment = (Appointment) element;
				System.out.println(appointment);
			}
		}

		/*
		 * add test
		 */
		/*
		 * Person employee = new Employee(3, null, null); Person client = new
		 * Client(1, null, null);
		 * 
		 * Appointment appointment = new Appointment(
		 * DateHelper.StringToDate("2011-06-15 13:45:00"),
		 * DateHelper.StringToDate("2011-06-15 14:45:00"), "test 4",
		 * "description 4", employee, client);
		 * 
		 * try { appHandler.add(appointment); } catch (ClassCastException ex) {
		 * ErrorHandler.getException(ex, new
		 * CurrentClassGetter().getClassName(), "main"); }
		 */
	}

}
