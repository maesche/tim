package tim.model;

import java.util.ArrayList;
import tim.observer.Observable;
import tim.observer.Observer;

public abstract class AbstractModel implements Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();	
	
	
	public abstract ArrayList<Element> get();
	public abstract void add(Element element) throws ClassCastException;
	public abstract void remove(Element element)  throws ClassCastException;
	public abstract void edit(Element element)  throws ClassCastException;
	
	
	/*
	 * Implémentation Patter Observer
	 * @see tim.observer.Observable#addObserver(tim.observer.Observer)
	 */
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}
	
	public void notifyObserver() {

	}

	public void removeObserver() {
		
	}
	
}
