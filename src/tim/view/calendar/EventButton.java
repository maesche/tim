package tim.view.calendar;

import java.awt.Insets;

import javax.swing.JButton;

import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.model.Appointment;

public class EventButton extends JButton {
		private String title;

	public EventButton(Appointment a) {
		
		this.setText(toString(a));
		this.setMargin(new Insets(0, 2, 0, 2));
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public String toString(Appointment a){
		String title;
		title = "<html>";
		//title += a.getEmployee().getFirstName() + "<br />";
		title += DateHelper.DateToString(a.getBegin(), Config.DATE_FORMAT_EVENT_HOUR) + "<br />";
		title += a.getTitle() + "<br />";
		title += "with " + a.getClient().getFirstName() + " " + a.getClient().getLastName() + "<br />";
		title += a.getDescription() + "<br />";
		
		title += "</html>";
		
		System.out.println(a.toString());
		
		return title;
		
	}
	
	

}
