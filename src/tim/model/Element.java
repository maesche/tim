package tim.model;

/**
 * Every object class which can be manipulated in views is of this type
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public abstract class Element {
	private long id;
	
	public Element(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

}
