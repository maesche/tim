package tim.calendar.model;

import java.util.ArrayList;


public abstract class PersonHandler extends AbstractModel {

	public abstract ArrayList<Element> get(long id);
	
	@Override
	public ArrayList<Element> get() {
		return get(0);
	}
}
