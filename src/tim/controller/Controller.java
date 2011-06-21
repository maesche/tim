package tim.controller;

import java.util.ArrayList;

import tim.application.exception.PersistanceException;
import tim.model.AbstractModel;
import tim.model.Appointment;
import tim.model.Client;
import tim.model.Element;
import tim.model.Employee;

public class Controller extends AbstractController {

	@Override
	public Element get(String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Element> getAll(String action) throws PersistanceException {
		if ("clients".equals(action)) {
			System.out.println("in");
			return this.models.get("ClientModel").get();
		}else {
			System.out.println(action);
			return null;
		}
	}

	@Override
	public void save(String action, Element element) throws ClassCastException, PersistanceException {
		String modelKey = null;
		AbstractModel  model = null;
		
		if (element instanceof Client) {
			modelKey = "ClientModel";
		}
		else if (element instanceof Appointment) {
			modelKey = "AppointmentModel";
		}
		else if (element instanceof Employee) {
			modelKey = "EmployeeModel";
		}
		
		model = this.models.get(modelKey);
		if (model != null) {
			if ("add".equals(action)) {
				model.add(element);
			}
		}
		



	}

	@Override
	public void saveAll(String action, ArrayList<Element> element) {
		// TODO Auto-generated method stub

	}

}
