package tim.application;

import java.awt.Dimension;

public class Resizer extends CustomObservable {
	private Dimension dimension;
	
	public Resizer() {
		GlobalRegistry.mvcLinker.registerSystemObservable(this);
	}
	
	public void setDimension(Dimension dimension) {
		setChanged();
		notifyObservers(dimension);
		this.dimension = new Dimension((int)dimension.getSize().getWidth(), (int)dimension.getSize().getHeight()-88);
	}

	public Dimension getDimension() {
		return dimension;
	}	
}
