package tim.view.calendar;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JButton;

import tim.application.Config;
import tim.application.utils.DateHelper;
import tim.model.Appointment;

public class EventButton extends JButton {

	Color color = null;
	private String title;
	private int duration;

	public EventButton(String title, int duration, Color color) {

		this.duration = duration;
		this.title = title;
		this.color = color;

		this.setMargin(new Insets(0, 2, 0, 2));
		this.setOpaque(true);
		this.setRolloverEnabled(false);
		this.setFocusPainted(false);
		this.setBackground(color);
		this.setText(title);

		// System.out.println(a.toString());

	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	

	
	
	

	/*
	 * public void paintComponent(Graphics g) {
	 * 
	 * Graphics2D g2 = (Graphics2D) g.create();
	 * g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
	 * 0.5f)); super.paintComponent(g2); g2.dispose(); }
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
