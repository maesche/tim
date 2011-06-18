package tim.view.calendar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DayNavigation extends JPanel {
	
	public DayNavigation(){
		this.setOpaque(false);
		this.setLayout(new FlowLayout());
		
		JButton btnToday = new JButton("Today");
		JButton btnPreview = new JButton("<");
		JTextField dayField = new JTextField("19.07.1986");
		JButton btnNext = new JButton(">");
		
		dayField.setMargin(new Insets(4,4,4,4));
		
		
		add(btnToday);
		add(btnPreview);
		add(dayField);
		add(btnNext);
	}
}
