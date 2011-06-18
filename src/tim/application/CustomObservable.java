package tim.application;

import java.util.Observable;

public abstract class CustomObservable extends Observable {
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
