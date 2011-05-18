package tim.calendar;

public abstract class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String comment;
	public Person(int id, String firstName, String lastName, String phone,
			String address, String comment) {
		this(id, firstName, lastName);
		this.phone = phone;
		this.address = address;
		this.comment = comment;
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
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
		return firstName + " " + lastName + " (" + id + ")";
	}
	
}
