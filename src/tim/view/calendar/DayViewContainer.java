package tim.view.calendar;


import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class DayViewContainer extends JPanel {

	public DayViewContainer(){
		
		
		int nbrPerson = 3;
		this.setOpaque(false);
		
		setLayout(new GridLayout(nbrPerson,1));
		this.setBounds(0, 0, 300, 300);
		add(new JLabel("asdfas"));
        //add(new Calendrier());	
        add(new UserCalendar());
        add(new UserCalendar());
	}
	

	
}
