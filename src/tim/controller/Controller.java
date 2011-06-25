package tim.controller;

import java.util.ArrayList;

import tim.application.exception.OperationNotPossibleException;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.model.AbstractModel;
import tim.model.Appointment;
import tim.model.Client;
import tim.model.Element;
import tim.model.Employee;

public class Controller extends AbstractController {
	
	private AbstractModel getModel(Element element, String elementKey) throws ResourceNotFoundException {
		String modelKey = null;
		AbstractModel  model = null;
		if (element instanceof Client || "client".equals(elementKey)) {
			modelKey = "ClientModel";
		}
		else if (element instanceof Appointment || "appointment".equals(elementKey)) {
			modelKey = "AppointmentModel";
		}
		else if (element instanceof Employee || "employee".equals(elementKey)) {
			modelKey = "EmployeeModel";
		}
		else {
			throw new ResourceNotFoundException("The model doesn't exist for Element '" + element + "' or elementKey '" + elementKey +"'", "global registry");
		}
		model = this.models.get(modelKey);
		
		return model;
	}


	@Override
	public Element get(String action, Object params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Element> getAll(String action) throws PersistanceException, ResourceNotFoundException {
		AbstractModel model = null;
		ArrayList<Element> ret = null;
		
		model = getModel(null, action);
		
		if (model != null) {
			ret = model.get();
		}
		else {
			ret = null;
		}
		return ret;
	}

	@Override
	public void save(String action, Element element) throws ClassCastException, PersistanceException, ResourceNotFoundException, OperationNotPossibleException {
		AbstractModel model = getModel(element, null);


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
				throw new OperationNotPossibleException(action, "add, delete or edit");

			}
		}
	}

	@Override
	public void saveAll(String action, ArrayList<Element> elements) throws ClassCastException, PersistanceException, ResourceNotFoundException, OperationNotPossibleException {
		for (Element element : elements) {
			save(action, element);
		}

	}

}
