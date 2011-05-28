package tim.view;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class TimeLines extends JPanel {

	public TimeLines() {
		int nbrPerson = 3;
		
		this.setBounds(0,0,400,400);
		setLayout(new GridLayout(nbrPerson,1));
        add(new Cal1());
        add(new Cal1());
        add(new Cal1());
	}

}
