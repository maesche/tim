package tim.model;

/**
 * This class is a Bean for Clients and represents the database table
 * corresponding to this object (most attributes are defined in Person)
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 * @see Person
 */
public class Client extends Person {

	public Client(int id, String firstName, String lastName, String phone,
			String address, String comment) {
		super(id, firstName, lastName, phone, address, comment);
		// TODO Auto-generated constructor stub
	}
	public Client(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}
}
