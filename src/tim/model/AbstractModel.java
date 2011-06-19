package tim.model;

import java.util.ArrayList;
import tim.application.CustomObservable;
import tim.application.exception.PersistanceException;

public abstract class AbstractModel extends CustomObservable {
	public abstract ArrayList<Element> get() throws PersistanceException;
	public abstract void add(Element element) throws ClassCastException, PersistanceException;
	public abstract void remove(Element element)  throws ClassCastException, PersistanceException;
	public abstract void edit(Element element)  throws ClassCastException, PersistanceException;
}
