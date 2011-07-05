package tim.model;

import java.util.ArrayList;
import tim.application.CustomObservable;
import tim.application.exception.PersistanceException;

/**
 * AbstractModel defines common operations for all models
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public abstract class AbstractModel extends CustomObservable {
	/**
	 * Returns an ArrayList of elements from the database
	 * Most subclasses implements this methods and offers filter to
	 * search specific information
	 * 
	 * @return ArrayList of elements
	 * @throws PersistanceException
	 */
	public abstract ArrayList<Element> get() throws PersistanceException;
	
	/**
	 * Adds an element to the database
	 * 
	 * @param element
	 * @throws ClassCastException
	 * @throws PersistanceException
	 */
	public abstract void add(Element element) throws ClassCastException, PersistanceException;
	
	/**
	 * Removes an element from the database
	 * 
	 * @param element
	 * @throws ClassCastException
	 * @throws PersistanceException
	 */
	public abstract void remove(Element element)  throws ClassCastException, PersistanceException;
	
	/**
	 * Edits element specified as parameter
	 * @param element
	 * @throws ClassCastException
	 * @throws PersistanceException
	 */
	public abstract void edit(Element element)  throws ClassCastException, PersistanceException;
}
