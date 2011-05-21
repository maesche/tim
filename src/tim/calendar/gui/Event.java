package tim.calendar.gui;

import javax.swing.JButton;


public class Event {
	
	private JButton event;
	
	public Event(String text) {
		event = new JButton(text);
	}
	
	public JButton draw() {
		return event;
	}

}
