package tim.calendar.model;

public class Employee extends Person {

	public Employee(int id, String firstName, String lastName, String phone,
			String address, String comment) {
		super(id, firstName, lastName, phone, address, comment);
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

}
