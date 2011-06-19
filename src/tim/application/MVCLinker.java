package tim.application;

import java.util.HashMap;
import java.util.Observable;

import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.model.AbstractModel;
import tim.model.AppointmentModel;
import tim.model.ClientModel;
import tim.model.EmployeeModel;
import tim.model.PersonModel;
import tim.view.AbstractView;

public class MVCLinker {
	private HashMap<String, AbstractModel> models;
	private HashMap<String, AbstractController> controllers;
	private HashMap<String, Observable> systemObservables;
	
	public MVCLinker() {
		models = new HashMap<String, AbstractModel>();
		controllers = new HashMap<String, AbstractController>();
		systemObservables = new HashMap<String, Observable>();
	}
	
	/**
	 * Get all globally registered models
	 * @return models
	 */
	public HashMap<String, AbstractModel> getModels() {
		return models;
	}
		
	public AbstractModel getModel(String modelKey) {
		AbstractModel model = models.get(modelKey);	
		/*
		 * if there is already an existing model of this type, we don't need to
		 * create a new instance. instead the old one is used.
		 */
		/*if (model == null) {	
			if (modelKey == "EmployeeModel") {
				model = new EmployeeModel();
			}
			else if (modelKey == "AppointmentModel") {
				model = new AppointmentModel();
			}
			else if (modelKey == "ClientModel") {
				model = new ClientModel();
			}
			else {
				throw new ResourceNotFoundException("The model '" + modelKey + "' doesn't exist.");
			}
			registerModel(model);
		}*/
		return model;
	}

	/**
	 * Register model to global register
	 * 
	 * @param model
	 */
	public void registerModel(AbstractModel model) {

		models.put(model.toString(), model);
	}
	
	/**
	 * Unregister model from global register
	 * @param model
	 */
	public void unregisterModel(AbstractModel model) {
		models.remove(model.toString());
	}


	/**
	 * Get all globally registered controller
	 * 
	 * @return controllers
	 */
	public HashMap<String, AbstractController> getControllers() {
		return controllers;
	}
	
	public void registerController(AbstractController controller) {
		controllers.put(controller.toString(), controller);
	}
	
	public void unregisterController(AbstractController controller) {
		controllers.remove(controller.toString());
	}
	
	public void addObserverToModel(String modelKey, AbstractView view) throws ResourceNotFoundException {
		AbstractModel model = models.get(modelKey);
		
		if (model == null) {
			throw new ResourceNotFoundException("The model '" + modelKey + "' doesn't exist in global registry.");
		}
		else {
			model.addObserver(view);
		}
	}
	
	public void removeObserverFromModel(String modelKey, AbstractView view) throws ResourceNotFoundException {
		AbstractModel model = models.get(modelKey);
		
		if (model == null) {
			throw new ResourceNotFoundException("The model '" + modelKey + "' doesn't exist in global registry.");
		}
		else {
			model.deleteObserver(view);
		}
	}
	
	public HashMap<String, Observable> getSystemObservables() {
		return systemObservables;
	}
	
	public void registerSystemObservable(Observable observable) {
		systemObservables.put(observable.toString(), observable);
	}
	
	public void unregisterSystemObservable(Observable observable) {
		controllers.remove(observable.toString());
	}
	
	public void addObserverToSystemResource(String resourceKey, AbstractView view) throws ResourceNotFoundException {
		Observable observable = systemObservables.get(resourceKey);
		
		if (observable == null) {
			throw new ResourceNotFoundException("The system resource '" + resourceKey + "' doesn't exist in global registry.");
		}
		else {
			observable.addObserver(view);
		}
	}
	
	public void removeObserverFromSystemResource(String resourceKey, AbstractView view) throws ResourceNotFoundException {
		Observable observable = systemObservables.get(resourceKey);
		
		if (observable == null) {
			throw new ResourceNotFoundException("The system resource '" + resourceKey + "' doesn't exist in global registry.");
		}
		else {
			observable.deleteObserver(view);
		}
	}
	
}
