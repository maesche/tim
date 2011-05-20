package tim.application;

import java.util.ArrayList;


public abstract class Handler {
	public abstract ArrayList<Element> get();
	public abstract void add(Element element);
	public abstract void remove(Element element);
	public abstract void edit(Element element);
}
