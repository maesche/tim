package tim.view.test;


import java.awt.GridLayout;

import javax.swing.JPanel;

public class CalendarContainer extends JPanel {

	public CalendarContainer(){
		
		
		int nbrPerson = 3;
		this.setOpaque(false);
		
		setLayout(new GridLayout(nbrPerson,1));
		this.setBounds(0, 0, 800, 600);
        add(new Calendrier());	
        add(new Calendrier());
        add(new Calendrier());
	}
	

	
}
