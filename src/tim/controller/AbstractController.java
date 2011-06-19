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
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
