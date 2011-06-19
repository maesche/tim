package tim.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import tim.application.Config;

public class ExceptionView extends JDialog {
	public ExceptionView (String error) {
		JLabel title = new JLabel(Config.RESSOURCE_BUNDLE.getString("applicationErrorSystem"));
		JLabel message = new JLabel(error);
		
		add(title, BorderLayout.NORTH);
		add(message, BorderLayout.CENTER);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		pack();

		setVisible(true);
	}
}
