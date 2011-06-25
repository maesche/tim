package tim.application;

import java.util.Observable;

public abstract class CustomObservable extends Observable {
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
