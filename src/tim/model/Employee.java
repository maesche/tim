package tim.model;

import java.awt.Color;

/**
 * This class is a Bean for Employees and represents the database table
 * corresponding to this object (most attributes are defined in Person).
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 * @see Person
 */
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
