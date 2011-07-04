/**
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 * 
 * @description CustomObservable which permits registering to global register in
 * specified format
 */
package tim.application;

import java.util.Observable;

public abstract class CustomObservable extends Observable {
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
