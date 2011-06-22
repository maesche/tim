package tim.controller;

import java.util.ArrayList;
import java.util.HashMap;

import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.model.AbstractModel;
import tim.model.Element;

public abstract class AbstractController {
	protected HashMap<String, AbstractModel> models = null;

	public AbstractController() {
		models = GlobalRegistry.mvcLinker.getModels();
	}
	
	public abstract Element get(String action);
	public abstract ArrayList<Element> getAll(String action) throws PersistanceException;
	
	public abstract void save(String action, Element element) throws ClassCastException, PersistanceException;
	public abstract void saveAll(String action, ArrayList<Element> elements) throws ClassCastException, PersistanceException;
	
	public String toString() {
		return this.getClass().getSimpleName();
	}



}
