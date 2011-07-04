package tim.application;

import java.util.HashMap;
import java.util.Observable;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.model.AbstractModel;
import tim.view.AbstractView;

/**
 * This class holds all globally registered models, controllers and observables
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
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
	 * Gets all globally registered models
	 * @return models
	 */
	public HashMap<String, AbstractModel> getModels() {
		return models;
	}
		
	
	/**
	 * Registers model to global register
	 * 
	 * @param model
	 */
	public void registerModel(AbstractModel model) {

		models.put(model.toString(), model);
	}
	
	/**
	 * Unregisters model from global register
	 * @param model
	 */
	public void unregisterModel(AbstractModel model) {
		models.remove(model.toString());
	}


	/**
	 * Gets all globally registered controller
	 * 
	 * @return controllers
	 */
	public HashMap<String, AbstractController> getControllers() {
		return controllers;
	}
	
	/**
	 * Unregisters a specific controller
	 * @param Controller object
	 */
	public void registerController(AbstractController controller) {
		controllers.put(controller.toString(), controller);
	}
	
	/**
	 * 
	 * @param controller
	 */
	public void unregisterController(AbstractController controller) {
		controllers.remove(controller.toString());
	}
	
	/**
	 * Adds an observer to a specified model
	 * @param modelkey (short class name)
	 * @param view
	 * @throws ResourceNotFoundException
	 */
	public void addObserverToModel(String modelKey, AbstractView view) throws ResourceNotFoundException {
		AbstractModel model = models.get(modelKey);
		
		if (model == null) {
			throw new ResourceNotFoundException(modelKey, "global registry");
		}
		else {
			model.addObserver(view);
		}
	}
	
	/**
	 * Removes an observer from a specified model
	 * @param modelKey (short class name)
	 * @param view
	 * @throws ResourceNotFoundException
	 */
	public void removeObserverFromModel(String modelKey, AbstractView view) throws ResourceNotFoundException {
		AbstractModel model = models.get(modelKey);
		
		if (model == null) {
			throw new ResourceNotFoundException(modelKey, "global registry");
		}
		else {
			model.deleteObserver(view);
		}
	}
	
	/**
	 * Returns all system observables
	 * @return systemObservables
	 */
	public HashMap<String, Observable> getSystemObservables() {
		return systemObservables;
	}
	
	/**
	 * Registers system observable
	 * @param observable
	 */
	public void registerSystemObservable(Observable observable) {
		systemObservables.put(observable.toString(), observable);
	}
	
	/**
	 * Unregisters a system observable
	 * @param observable
	 */
	public void unregisterSystemObservable(Observable observable) {
		controllers.remove(observable.toString());
	}
	
	/**
	 * Adds an observable (eg. AbstractView) to a specified system resource
	 * @param resourceKey (eg. short class name)
	 * @param view
	 * @throws ResourceNotFoundException
	 */
	public void addObserverToSystemResource(String resourceKey, AbstractView view) throws ResourceNotFoundException {
		Observable observable = systemObservables.get(resourceKey);
		
		if (observable == null) {
			throw new ResourceNotFoundException(resourceKey, "global registry");
		}
		else {
			observable.addObserver(view);
		}
	}
	
	/**
	 * Removes a system observer from the global register
	 * @param resourceKey (eg. short class name)
	 * @param view
	 * @throws ResourceNotFoundException
	 */
	public void removeObserverFromSystemResource(String resourceKey, AbstractView view) throws ResourceNotFoundException {
		Observable observable = systemObservables.get(resourceKey);
		
		if (observable == null) {
			throw new ResourceNotFoundException(resourceKey, "global registry");
		}
		else {
			observable.deleteObserver(view);
		}
	}
	
}
