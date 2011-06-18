package tim.application;

import java.util.HashMap;

import tim.controller.AbstractController;
import tim.model.AbstractModel;
import tim.view.AbstractView;

public class MVCLinker {
	private HashMap<String, AbstractModel> models;
	private HashMap<String, AbstractController> controllers;
	
	public MVCLinker() {
		models = new HashMap<String, AbstractModel>();
		controllers = new HashMap<String, AbstractController>();
	}
	
	/**
	 * Get all globally registered models
	 * @return models
	 */
	public HashMap<String, AbstractModel> getModels() {
		return models;
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
	 * Get all globally registered controllers
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
	
	public void addObserverToModel(AbstractModel model, AbstractView view) {
		model.addObserver(view);
	}
	
	public void removeObserverFromModel(AbstractModel model, AbstractView view) {
		model.deleteObserver(view);
	}
}
