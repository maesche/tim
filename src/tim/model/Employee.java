package tim.model;

import java.awt.Color;

public class Employee extends Person {

	private Calendar calendar;

	public Employee(int id, String firstName, String lastName, String phone,
			String address, String comment, Color color) {
		super(id, firstName, lastName, phone, address, comment);
	}
	

	
	public Employee(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}


	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}

}
