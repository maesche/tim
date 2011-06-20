package tim.view.calendar;

import java.util.ArrayList;

import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.controller.AbstractController;
import tim.model.Client;
import tim.model.Element;

public class ClientDialogController extends AbstractController {
	
	public void save(Client client) throws ClassCastException, PersistanceException {
		GlobalRegistry.mvcLinker.getModels().get("ClientModel").add(client);
	}
	
	public void delete(Client client) throws ClassCastException, PersistanceException {
		GlobalRegistry.mvcLinker.getModels().get("ClientModel").remove(client);
	}
	
	public ArrayList<Element> getClients() throws PersistanceException {
		return this.models.get("ClientModel").get();
		
	}
}
