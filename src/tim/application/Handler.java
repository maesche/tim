package tim.application;

import java.util.ArrayList;


public abstract class Handler {
	public abstract ArrayList<Element> get();
	public abstract void add(Element element) throws ClassCastException;
	public abstract void remove(Element element)  throws ClassCastException;
	public abstract void edit(Element element)  throws ClassCastException;
}
