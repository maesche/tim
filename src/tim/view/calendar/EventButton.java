package tim.view.calendar;

import javax.swing.JButton;

import tim.model.Appointment;

public class EventButton extends JButton {
		private String title;

	public EventButton(Appointment a) {
		
		
		
		//this.setText("<html>" + a.getEmployee().getFirstName() + "<br />" + a.getTitle() + "</html>");
		this.setText(toString(a));
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public String toString(Appointment a){
		String title;
		title = "<html>";
		//title += a.getEmployee().getFirstName() + "<br />";
		title += a.getBegin() + "<br />";
		title += a.getTitle() + "<br />";
		title += "with" + a.getClient().getFirstName() + "<br />";
		
		title += "</html>";
		
		return title;
		
	}
	
	

}
