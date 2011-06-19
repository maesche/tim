package tim.controller;

import java.util.HashMap;

import tim.application.GlobalRegistry;
import tim.application.exception.ResourceNotFoundException;
import tim.model.AbstractModel;

public abstract class AbstractController {
	protected HashMap<String, AbstractModel> models = null;

	public AbstractController() {
		models = GlobalRegistry.mvcLinker.getModels();
	}


	/*public void addModel(String modelKey) throws ResourceNotFoundException {
		AbstractModel model = GlobalRegistry.mvcLinker.getModel(modelKey);
		models.put(modelKey, model);
	}


	public void removeModel(AbstractModel model) {
		models.remove(model.toString());
	}
	*/
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
