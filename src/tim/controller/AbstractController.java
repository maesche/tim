package tim.controller;

import java.util.ArrayList;
import java.util.HashMap;

import tim.application.GlobalRegistry;
import tim.application.exception.OperationNotPossibleException;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.model.AbstractModel;
import tim.model.Element;

/**
 * AbstractController which defines common controller functionalities
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public abstract class AbstractController {
	/*Hashmap which holds all used models */
	protected HashMap<String, AbstractModel> models = null;

	/**
	 * Registers itself to global register on load
	 */
	public AbstractController() {
		models = GlobalRegistry.mvcLinker.getModels();
	}
	
	/**
	 * Gets an Element for specified modelKey and params
	 * (actually not implemented)
	 * 
	 * @param modelKey
	 * @param params
	 */
	public abstract Element get(String modelKey, Object params);
	
	/**
	 * Gets an ArrayList of all elements in specified model (modelKey)
	 * 
	 * @param modelKey
	 * @throws PersistanceException
	 * @throws ResourceNotFoundException
	 */
	public abstract ArrayList<Element> getAll(String modelKey) throws PersistanceException, ResourceNotFoundException;
	
	/**
	 * Saves the specified element in its handled model
	 * @param modelKey
	 * @param element
	 * @throws ClassCastException
	 * @throws PersistanceException
	 * @throws ResourceNotFoundException
	 * @throws OperationNotPossibleException
	 */
	public abstract void save(String modelKey, Element element) throws ClassCastException, PersistanceException, ResourceNotFoundException, OperationNotPossibleException;
	
	/**
	 * Saves an ArrayList of elements in its handled model
	 * (currently not implemented)
	 * @param modelKey
	 * @param elements
	 * @throws ClassCastException
	 * @throws PersistanceException
	 * @throws ResourceNotFoundException
	 * @throws OperationNotPossibleException
	 */
	public abstract void saveAll(String modelKey, ArrayList<Element> elements) throws ClassCastException, PersistanceException, ResourceNotFoundException, OperationNotPossibleException;
	
	public String toString() {
		return this.getClass().getSimpleName();
	}



}
