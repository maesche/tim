package tim.calendar.model;

import java.util.ArrayList;

import tim.application.Element;
import tim.application.Handler;

public abstract class PersonHandler extends Handler {

	public abstract ArrayList<Element> get(long id);
	
	@Override
	public ArrayList<Element> get() {
		return get(0);
	}
}
