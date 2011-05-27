package tim.observer;

import tim.observer.Observer;

public interface Observable {
	public void addObserver(Observer obs);
	public void removeObserver();
	public void notifyObserver();
}