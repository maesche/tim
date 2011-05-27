package tim.model;

import java.util.ArrayList;


public abstract class AbstractModel {
	public abstract ArrayList<Element> get();
	public abstract void add(Element element) throws ClassCastException;
	public abstract void remove(Element element)  throws ClassCastException;
	public abstract void edit(Element element)  throws ClassCastException;
}
