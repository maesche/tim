package tim.calendar.model;

import java.util.Date;
import tim.application.DateHelper;
import tim.application.Element;

public class Appointment extends Element {

	private Date begin;
	private Date end;
	private String title;
	private String description;
	
	private Person employee;
	private Person client;
	
	public Appointment(long id, Date begin, Date end, String title,
			String description, Person employee, Person client) {
		super(id);
		initialize(begin, end, title, description, employee, client);

	}
	
	private void initialize(Date begin, Date end, String title,
			String description, Person employee, Person client) {
		this.begin = begin;
		this.end = end;
		this.title = title;
		this.description = description;
		this.employee = employee;
		this.client = client;
	}
	
	public Appointment(Date begin, Date end, String title, String description, Person employee, Person client) {
		super(new Date().getTime());	
		initialize(begin, end, title, description, employee, client);
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
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
		ret += "titre:\t\t" + title + "\n";
		ret += "description:\t" + description + "\n";
		ret += "begin:\t\t" + DateHelper.DateToString(begin) + "\n"; 
		ret += "end:\t\t" + DateHelper.DateToString(end) + "\n"; 
		ret += "employee:\t" + employee.toString() + "\n"; 
		ret += "client:\t\t" + client.toString() + "\n"; 
		
		return  ret;
		
	}
	 
	
}
