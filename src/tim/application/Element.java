package tim.application;

public abstract class Element {
	private long id;
	
	public Element(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

}