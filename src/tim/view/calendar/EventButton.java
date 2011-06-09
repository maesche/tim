package tim.view.calendar;

import java.awt.Insets;

import javax.swing.JButton;

import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.model.Appointment;

public class EventButton extends JButton {
		private String title;
		private long duration;

	public EventButton(Appointment a) {
		
		this.title = toString(a);
		this.setText(this.title);
		this.setMargin(new Insets(0, 2, 0, 2));
		this.duration = a.getBegin().getTime();//(a.getEnd().getTime() - a.getBegin().getTime());
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public String toString(Appointment a){
		String title;
		title = "<html>";
		//title += a.getEmployee().getFirstName() + "<br />";
		title += DateHelper.DateToString(a.getBegin(), Config.DATE_FORMAT_EVENT_HOUR) + " - " + DateHelper.DateToString(a.getEnd(), Config.DATE_FORMAT_EVENT_HOUR) + "<br />";
		title += a.getTitle() + "<br />";
		title += "with " + a.getClient().getFirstName() + " " + a.getClient().getLastName() + "<br />";
		title += a.getDescription() + "<br />";
		title += "durée: " + String.valueOf(this.duration) + "<br />";
		
		title += "</html>";
		
		return title;
		
	}
	
	

}
