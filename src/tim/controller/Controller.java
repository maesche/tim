package tim.controller;

import java.util.ArrayList;

import tim.application.exception.PersistanceException;
import tim.model.AbstractModel;
import tim.model.Appointment;
import tim.model.Client;
import tim.model.Element;
import tim.model.Employee;

public class Controller extends AbstractController {
	
	private AbstractModel getModel(Element element) {
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
		
		return model;
	}

	@Override
	public Element get(String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Element> getAll(String action) throws PersistanceException {
		ArrayList<Element> ret = null;
		if ("clients".equals(action)) {
			System.out.println("in");
			ret = this.models.get("ClientModel").get();
		}else {
			System.out.println(action);
			ret = null;
		}
		return ret;
	}

	@Override
	public void save(String action, Element element) throws ClassCastException, PersistanceException {
		AbstractModel model = getModel(element);

		if (model != null) {
			if ("add".equals(action)) {
				model.add(element);
			}
			else if ("delete".equals(action)) {
				model.remove(element);
			}
			else if (("edit").equals(action)) {
				model.edit(element);
			}
			else {
				System.out.println("Your action is not valid. Use add, delete or edit");
			}
		}
	}

	@Override
	public void saveAll(String action, ArrayList<Element> elements) throws ClassCastException, PersistanceException {
		for (Element element : elements) {
			save(action, element);
		}

	}

}
