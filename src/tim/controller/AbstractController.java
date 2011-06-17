package tim.controller;

import java.util.HashMap;

import tim.model.AbstractModel;

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

}
