package tim.application;

import java.awt.Dimension;

/**
 * Knows the application size and informs all observer if size changes.
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class Resizer extends CustomObservable {
	private Dimension dimension;
	
	/**
	 * Registers itself to global register
	 */
	public Resizer() {
		GlobalRegistry.mvcLinker.registerSystemObservable(this);
	}
	
	/**
	 * Sets the new application size. If called all observers will be informed.
	 * @param dimension
	 */
	public void setDimension(Dimension dimension) {
		setChanged();
		notifyObservers(dimension);
		this.dimension = new Dimension((int)dimension.getSize().getWidth(), (int)dimension.getSize().getHeight()-88);
	}

	/**
	 * Returns the current application size
	 * 
	 * @return dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}	
}
