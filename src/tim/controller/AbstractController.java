package tim.controller;

import java.util.HashMap;

import tim.model.AbstractModel;

public abstract class AbstractController {
	protected HashMap<String, AbstractModel> models = null;
	
	public AbstractController() {
		models = new HashMap<String, AbstractModel>();
	}
	
	public synchronized void addModel(AbstractModel model) {
		models.put(model.toString(), model);
		
	}
	
	public synchronized void removeModel(AbstractModel model) {
		models.remove(model.toString());
	}
}
