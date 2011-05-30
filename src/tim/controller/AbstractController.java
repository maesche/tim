package tim.controller;

import java.util.HashMap;

import tim.model.AbstractModel;

public abstract class AbstractController {
	protected HashMap<String, AbstractModel> models = null;
	
	public AbstractController() {
		models = new HashMap<String, AbstractModel>();
	}
	
	public void addModel(String name, AbstractModel model) {
		models.put(name, model);
	}
	
	public void removeModel(AbstractModel model) {
		models.remove(model);
	}	
}
