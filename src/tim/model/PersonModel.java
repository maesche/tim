package tim.model;

import java.util.ArrayList;

import tim.application.exception.PersistanceException;


public abstract class PersonModel extends AbstractModel {

	public abstract ArrayList<Element> get(long id) throws PersistanceException;
	
	@Override
	public ArrayList<Element> get() throws PersistanceException {
		return get(0);
	}
	
}
