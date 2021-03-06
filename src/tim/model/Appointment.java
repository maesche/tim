package tim.model;

import java.util.Date;

import tim.application.Config;
import tim.application.utils.DateHelper;

/**
 * This class is a Bean for Appointments and represents the database table
 * corresponding to this object
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class Appointment extends Element {

	private Date begin;
	private Date end;
	private String description;
	
	private Person employee;
	private Person client;
	
	public Appointment(long id, Date begin, Date end, 
			String description, Person employee, Person client) {
		super(id);
		initialize(begin, end, description, employee, client);

	}
	
	private void initialize(Date begin, Date end, 
			String description, Person employee, Person client) {
		this.begin = begin;
		this.end = end;
		this.description = description;
		this.employee = employee;
		this.client = client;
	}
	
	public Appointment(Date begin, Date end, String description, Person employee, Person client) {
		super(new Date().getTime());	
		initialize(begin, end, description, employee, client);
	}
	
	
	/**
	 * @return the begin
	 */
	public Date getBegin() {
		return begin;
	}
	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the employee
	 */
	public Person getEmployee() {
		return employee;
	}
	/**
	 * @return the client
	 */
	public Person getClient() {
		return client;
	}
	
	public String toString() {
		String ret = "";
		
		ret += "id:\t\t" + String.valueOf(super.getId()) + "\n";
		ret += "description:\t" + description + "\n";
		ret += "begin:\t\t" + DateHelper.DateToString(begin, Config.DATE_FORMAT_LONG) + "\n"; 
		ret += "end:\t\t" + DateHelper.DateToString(end, Config.DATE_FORMAT_LONG) + "\n"; 
		ret += "employee:\t" + employee.toString() + "\n"; 
		ret += "client:\t\t" + client.toString() + "\n"; 
		
		return  ret;
		
	}
	 
	
}
