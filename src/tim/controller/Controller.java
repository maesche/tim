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
	
	private AbstractModel getModel(Element element, String modelKey) throws ResourceNotFoundException {
		String key = null;
		AbstractModel  model = null;
		if (element instanceof Client || "client".equals(key)) {
			key = "ClientModel";
		}
		else if (element instanceof Appointment || "appointment".equals(key)) {
			key = "AppointmentModel";
		}
		else if (element instanceof Employee || "employee".equals(key)) {
			key = "EmployeeModel";
		}
		else {
			throw new ResourceNotFoundException("The model doesn't exist for Element '" + element + "' or modelKey '" + key +"'", "global registry");
		}
		model = this.models.get(key);
		
		return model;
	}


	@Override
	/**
	 * {@inheritDoc}
	 */
	public Element get(String modelKey, Object params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public ArrayList<Element> getAll(String modelKey) throws PersistanceException, ResourceNotFoundException {
		AbstractModel model = null;
		ArrayList<Element> ret = null;
		
		model = getModel(null, modelKey);
		
		if (model != null) {
			ret = model.get();
		}
		else {
			ret = null;
		}
		return ret;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public void save(String modelKey, Element element) throws ClassCastException, PersistanceException, ResourceNotFoundException, OperationNotPossibleException {
		AbstractModel model = getModel(element, null);


		if (model != null) {
			if ("add".equals(modelKey)) {
				model.add(element);
			}
			else if ("delete".equals(modelKey)) {
				model.remove(element);
			}
			else if (("edit").equals(modelKey)) {
				model.edit(element);
			}
			else {
				throw new OperationNotPossibleException(modelKey, "add, delete or edit");

			}
		}
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public void saveAll(String modelKey, ArrayList<Element> elements) throws ClassCastException, PersistanceException, ResourceNotFoundException, OperationNotPossibleException {
		for (Element element : elements) {
			save(modelKey, element);
		}
	}

}
