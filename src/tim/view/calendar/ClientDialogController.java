package tim.view.calendar;

import java.util.ArrayList;

import tim.application.exception.PersistanceException;
import tim.controller.AbstractController;
import tim.model.Element;

public class ClientDialogController extends AbstractController {
	public ArrayList<Element> getClients() throws PersistanceException {
		return this.models.get("ClientModel").get();
		
	}
}
