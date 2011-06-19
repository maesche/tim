package tim.model;

import java.util.ArrayList;


public abstract class PersonModel extends AbstractModel {

	public abstract ArrayList<Element> get(long id);
	
	@Override
	public ArrayList<Element> get() {
		return get(0);
	}
	
}
