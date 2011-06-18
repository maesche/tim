package tim.model;

import java.util.ArrayList;
import java.util.Observable;

public abstract class AbstractModel extends Observable {
	public abstract ArrayList<Element> get();
	public abstract void add(Element element) throws ClassCastException;
	public abstract void remove(Element element)  throws ClassCastException;
	public abstract void edit(Element element)  throws ClassCastException;
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
