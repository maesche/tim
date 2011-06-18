package tim.model;

import java.util.ArrayList;
import tim.application.CustomObservable;

public abstract class AbstractModel extends CustomObservable {
	public abstract ArrayList<Element> get();
	public abstract void add(Element element) throws ClassCastException;
	public abstract void remove(Element element)  throws ClassCastException;
	public abstract void edit(Element element)  throws ClassCastException;
}
