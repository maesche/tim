package tim.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * This class is a Bean for Calendars and represents the database table
 * corresponding to this object
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class Calendar extends Element {
	
	private Color color;
	private ArrayList<Appointment> appointments;

	public Calendar(long id, Color color) {
		super(id);
		this.color = color;
		appointments = new ArrayList<Appointment>();
	}
	
	public Calendar(long id, Color color, ArrayList<Appointment> appointments) {
		super(id);
		this.color = color;
		this.appointments = appointments;
	}
	
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	
	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public Color getColor() {
		return color;
	}

}