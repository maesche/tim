package tim.model;

import java.awt.Color;

public class Employee extends Person {
	private Color color;
	private Calendar calendar;

	public Employee(int id, String firstName, String lastName, String phone,
			String address, String comment, Color color) {
		super(id, firstName, lastName, phone, address, comment);
		init(color);
	}
	
	public Employee(int id, String firstName, String lastName, Color color) {
		this(id, firstName, lastName);
		init(color);
	}
	
	public Employee(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		init(null);
	}
	private void init(Color color) {
		this.color = color;
		
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}
	
	/**
	 * 
	 * @deprecated use Calendar.getColor instead
	 */
	public Color getColor() {
		return color;
	}
}
