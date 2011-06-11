package tim.controller;

import java.util.HashMap;

import tim.model.AbstractModel;
import tim.model.ModelClassLoader;

public abstract class AbstractController {
	protected HashMap<String, AbstractModel> models = null;
	
	public AbstractController() {
		models = new HashMap<String, AbstractModel>();
	}
	
	public void addModel(AbstractModel model) {
		models.put(model.toString(), model);
		try {
			Class.forName("tim.model." + "AppointmentModel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void removeModel(AbstractModel model) {
		models.remove(model.toString());
	}
	
	public AbstractModel getModel(String name) throws ClassNotFoundException {
		//AbstractModel model = Class.forName("tim.model." + "AppointmentModel");
		ModelClassLoader classLoader = new ModelClassLoader();
		Object model = classLoader.loadClass("tim.model." + "AppointmentModel", true);

		return (AbstractModel) model;
	}

}
