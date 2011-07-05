package tim.model;


/**
 * This class is a Bean for Persons and holds common informations
 * between all child objects
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public abstract class Person extends Element {
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String comment;
	public Person(long id, String firstName, String lastName, String phone,
			String address, String comment) {
		this(id, firstName, lastName);
		this.phone = phone;
		this.address = address;
		this.comment = comment;
	}

	public Person(long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getPhone() {
		return phone;
	}



	public String getAddress() {
		return address;
	}



	public String getComment() {
		return comment;
	}



	public String toString() {
		return firstName + " " + lastName;
	}
	
}
