package tim.model;

import java.util.ArrayList;
import java.util.Date;

import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;

public class CalendarModel extends AbstractModel {

	public ArrayList<Element> get(Employee employee, Date begin, Date end) {
		EmployeeModel employeeModel = (EmployeeModel) GlobalRegistry.mvcLinker.getModels().get("EmployeeModel");
		AppointmentModel appointmentModel = (AppointmentModel) GlobalRegistry.mvcLinker.getModels().get("AppointmentModel");
		return null;
		
	}
	
	@Override
	public ArrayList<Element> get() throws PersistanceException {
		return get(null, null, null);
	}

	@Override
	public void add(Element element) throws ClassCastException,
			PersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Element element) throws ClassCastException,
			PersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Element element) throws ClassCastException,
			PersistanceException {
		// TODO Auto-generated method stub

	}

}
