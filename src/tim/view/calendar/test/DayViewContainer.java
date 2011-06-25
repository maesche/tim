package tim.view.calendar.test;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;
import tim.model.Element;
import tim.view.ChildView;
import tim.view.ParentView;

public class DayViewContainer extends JPanel implements ChildView {
	
	private ArrayList<Element> elements;
	private UserCalendar userCalendar;
	
	public void load() {
		setLayout(new GridLayout(elements.size(),1));
		
		for (Element element : elements) {
			userCalendar = new UserCalendar();
			userCalendar.setData(element);
			add(userCalendar);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParentView(ParentView view) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setData(Object value) {
		this.elements = (ArrayList<Element>) value;

	}

}
