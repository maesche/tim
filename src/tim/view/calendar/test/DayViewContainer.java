package tim.view.calendar.test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;

import tim.application.GlobalRegistry;
import tim.application.Resizer;
import tim.model.Element;
import tim.view.ChildView;
import tim.view.ParentView;

public class DayViewContainer extends JPanel implements ChildView {
	
	private ArrayList<Element> elements;
	private UserCalendar userCalendar;
	private ParentView parentView;
	private Dimension dimension;
	
	public DayViewContainer() {
		GlobalRegistry.resizer.addObserver(this);
		setOpaque(false);
	}
	
	public void load() {
		dimension = getSize();
		setLayout(new GridLayout(elements.size(),1));
		
		for (Element element : elements) {
			userCalendar = new UserCalendar();
			userCalendar.setData(element);
			userCalendar.setParentView(parentView);
			userCalendar.load();;
			add(userCalendar);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Resizer) {
			this.dimension = (Dimension) arg;
			repaint();
		}

	}

	@Override
	public void setParentView(ParentView view) {
		this.parentView = view;

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
	
	public void validate(){
	    setSize(dimension);
	    setPreferredSize(dimension);
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    validate();
	}
}
