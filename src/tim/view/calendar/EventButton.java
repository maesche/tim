package tim.view.calendar;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;

import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.model.Appointment;

public class EventButton extends JButton {
		

	private String title;
	private int duration;

	public EventButton(Appointment a, Color userColor) {
		
		
		this.duration = DateHelper.DateDiff(a.getBegin(), a.getEnd());
		this.title = toString(a);
		this.setText(this.title);
		this.setMargin(new Insets(0, 2, 0, 2));
		this.setOpaque(true);
		this.setBackground(userColor);
        
		//System.out.println(a.toString());
		
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public String toString(Appointment a){
		String title;
		title = "<html>";
		title += DateHelper.DateToString(a.getBegin(), Config.DATE_FORMAT_EVENT_HOUR) + " - " + DateHelper.DateToString(a.getEnd(), Config.DATE_FORMAT_EVENT_HOUR) + "<br />";
		title += a.getTitle() + "<br />";
		title += "with " + a.getClient().getFirstName() + " " + a.getClient().getLastName() + "<br />";
		title += a.getDescription() + "<br />";
		title += "durée: " + String.valueOf(duration) + "<br />";
		
		title += "</html>";
		
		return title;
		
	}
	
	

}
