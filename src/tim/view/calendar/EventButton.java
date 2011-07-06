package tim.view.calendar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JButton;

import tim.application.utils.DateHelper;
import tim.model.Appointment;
import tim.model.Employee;

/**
 * Design an appointment
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.07.04 
 */

public class EventButton extends JButton {
	private Color color = null;
	private String title;
	private int duration;
	private Date begin, end;
	private Appointment appointment;
	
	private Employee employee;
	
	public EventButton(Appointment appointment) {

		this.appointment = appointment;
		this.duration = DateHelper.DateDiff(appointment.getBegin(), appointment.getEnd());
		this.title = "<html>" + appointment.getClient().getFirstName() + " " + appointment.getClient().getLastName() + "</html>";
		Employee e = (Employee) appointment.getEmployee();
		this.color = e.getCalendar().getColor();
		this.begin = appointment.getBegin();
		this.end = appointment.getEnd();

		this.setMargin(new Insets(0, 2, 0, 2));
		this.setOpaque(true);
		this.setRolloverEnabled(false);
		this.setFocusPainted(false);
		this.setBackground(color);
		this.setText(title);
		this.setToolTipText(appointment.getDescription());

	}
	
	public EventButton(Employee employee, Date begin, Date end){
		this.employee = employee;
		this.begin = begin;
		this.end = end;
		this.duration = DateHelper.DateDiff(begin, end);
		this.title = "";
		this.color = null;
		this.appointment = null;
		
		this.setBorderPainted(false);
        this.setBackground(new Color(1f,1f,1f,0));
        this.setOpaque(false);
	}
	
	
	public EventButton(Date begin, Date end) {
		this.begin = begin;
		this.end = end;
		this.duration = DateHelper.DateDiff(begin, end);
		this.title = "";
		this.color = null;
		this.appointment = null;
		
		this.setBorderPainted(false);
        this.setBackground(new Color(1f,1f,1f,0));
        this.setOpaque(false);
	}
	
	/**
	 * Sets Employee
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Gets Event Title
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Gets Event duration
	 * @return
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * Sets Event duration
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * Gets Event Color
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Sets Event color
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Gets Event date begin
	 * @return
	 */
	public Date getBegin() {
		return begin;
	}
	/**
	 * Gets Event date end
	 * @return
	 */
	public Date getEnd() {
		return end;
	}
	/**
	 * Gets Event appointment
	 * @return
	 */
	public Appointment getAppointment() {
		return appointment;
	}
	/**
	 * Gets Employee of the event
	 * @return
	 */
	public Employee getEmployee() {
		return employee;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	/**
	 * Shows the Events
	 */
	public String toString(){
		String message = "";
		message += employee.getFirstName();
		//message += ": " + begin.getHours();
		return message;
	}
	
}
