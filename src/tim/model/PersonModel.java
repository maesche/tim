package tim.model;

import java.util.ArrayList;

import tim.application.exception.PersistanceException;

/**
 * This models contains common operation for all Person objects
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public abstract class PersonModel extends AbstractModel {

	public abstract ArrayList<Element> get(long id) throws PersistanceException;
	
	@Override
	public ArrayList<Element> get() throws PersistanceException {
		return get(0);
	}
	
}
