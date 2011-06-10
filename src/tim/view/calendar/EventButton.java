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

	public EventButton(Appointment a, Color userColor) {

		this.duration = DateHelper.DateDiff(a.getBegin(), a.getEnd());

		super.setText(toString(a));
		this.color = userColor;

		this.setMargin(new Insets(0, 2, 0, 2));
		this.setOpaque(true);
		this.setRolloverEnabled(false);
		this.setFocusPainted(false);
		this.setBackground(color);

		// System.out.println(a.toString());

	}

	public String getTitle() {
		return title;
	}

	public int getDuration() {
		return duration;
	}

	public String toString(Appointment a) {
		String title;
		title = "<html>";
		title += DateHelper.DateToString(a.getBegin(),
				Config.DATE_FORMAT_EVENT_HOUR)
				+ " - "
				+ DateHelper.DateToString(a.getEnd(),
						Config.DATE_FORMAT_EVENT_HOUR) + "<br />";
		title += a.getTitle() + "<br />";
		title += "with " + a.getClient().getFirstName() + " "
				+ a.getClient().getLastName() + "<br />";
		title += a.getDescription() + "<br />";
		title += "durée: " + String.valueOf(duration) + "<br />";

		title += "</html>";

		return title;

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
