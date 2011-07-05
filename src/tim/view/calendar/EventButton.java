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
	
	/**
	 * Constructor using when the appointment must be visible
	 * @param appointment
	 */
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
	
	/**
	 * Constructor using when the appointment must be invisible
	 * @param employee
	 * @param begin
	 * @param end
	 */
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
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getTitle() {
		return title;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Date getBegin() {
		return begin;
	}
	public Date getEnd() {
		return end;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public Employee getEmployee() {
		return employee;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	public String toString(){
		String message = "";
		message += employee.getFirstName();
		//message += ": " + begin.getHours();
		return message;
	}
	
}
