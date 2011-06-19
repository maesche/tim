package tim.controller;

import java.util.HashMap;

import tim.application.GlobalRegistry;
import tim.model.AbstractModel;

public abstract class AbstractController {
	protected HashMap<String, AbstractModel> models = null;

	public AbstractController() {
		models = new HashMap<String, AbstractModel>();
		System.out.println(this.toString());
	}

	public void addModel(AbstractModel model) {
		AbstractModel globalModel = GlobalRegistry.mvcLinker.getModels().get(
				model.toString());
		/*
		 * if there is already an existing model of this type, we don't need to
		 * create a new instance. instead the old one is used.
		 */
		if (globalModel == null) {
			GlobalRegistry.mvcLinker.registerModel(model);
			models.put(model.toString(), model);
		} else {
			models.put(globalModel.toString(), model);;
		}

	}

	public void removeModel(AbstractModel model) {
		models.remove(model.toString());
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
