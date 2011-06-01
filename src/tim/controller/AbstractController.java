package tim.controller;

import tim.model.AbstractModel;

public abstract class AbstractController {
	protected AbstractModel model = null;
	
	public void addModel(AbstractModel model) {
		this.model = model;
	}
	
	public void removeModel() {
		model = null;
	}
}
