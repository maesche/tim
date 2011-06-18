package tim.application;

import java.util.HashMap;

import tim.model.AbstractModel;
import tim.view.AbstractView;

public class MVCLinker {
	private HashMap <String, AbstractModel> models;
	
	public MVCLinker() {
		models = new HashMap <String, AbstractModel>();
	}
	
	
	public HashMap<String, AbstractModel> getModels() {
		return models;
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



	public void addToObserverRegistry(AbstractModel model, AbstractView view) {
		model.addObserver(view);
	}
	
	public void removeFromObserverRegistry(AbstractModel model, AbstractView view) {
		model.deleteObserver(view);
	}
}
