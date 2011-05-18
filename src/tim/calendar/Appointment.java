package tim.calendar;

import java.util.Date;
import tim.application.DateHelper;

public class Appointment {
	private int id;
	private Date begin;
	private Date end;
	private String title;
	private String description;
	
	private Employee employee;
	private Client client;
	
	public Appointment(int id, Date begin, Date end, String title,
			String description, Employee employee, Client client) {
		super();
		this.id = id;
		this.begin = begin;
		this.end = end;
		this.title = title;
		this.description = description;
		this.employee = employee;
		this.client = client;
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	
	public String toString() {
		String ret = "";
		
		ret += "id:\t\t" + String.valueOf(id) + "\n";
		ret += "titre:\t\t" + title + "\n";
		ret += "description:\t" + description + "\n";
		ret += "begin:\t\t" + DateHelper.DateToString(begin) + "\n"; 
		ret += "end:\t\t" + DateHelper.DateToString(end) + "\n"; 
		
		return  ret;
		
	}
	
	
}
