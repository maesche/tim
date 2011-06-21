package tim.controller;

import java.util.ArrayList;

import tim.application.exception.PersistanceException;
import tim.model.Element;

public class Controller extends AbstractController {

	@Override
	public Element get(String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Element> getAll(String action) throws PersistanceException {
		if ("clients".equals(action)) {
			System.out.println("in");
			return this.models.get("ClientModel").get();
		}else {
			System.out.println(action);
			return null;
		}
	}

	@Override
	public void save(String action, Element element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAll(String action, ArrayList<Element> element) {
		// TODO Auto-generated method stub

	}

}
