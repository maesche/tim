package tim.controller;

import java.util.ArrayList;

import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.EmployeeModel;

public class DayViewController extends AbstractController {
	
	public ArrayList<Element> getEmployees() throws PersistanceException {	
		return this.models.get("EmployeeModel").get();
	}

	@Override
	public Element get(String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Element> getAll(String action) throws PersistanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(String action, Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll(String action, ArrayList<Element> element) {
		// TODO Auto-generated method stub
		
	}
}
