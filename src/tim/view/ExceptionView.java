package tim.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tim.application.Config;

public class ExceptionView extends JDialog {
	public ExceptionView(String error) {
		JLabel title = new JLabel();
		if (Config.RESSOURCE_BUNDLE != null) {
			title.setText(Config.RESSOURCE_BUNDLE
					.getString("applicationErrorSystem"));
		} else {
			title.setText("The following error occured: ");
		}
		//JLabel message = new JLabel(error);
		
		JTextArea message = new JTextArea(error);
		JScrollPane scrollPaneArea = 
		      new JScrollPane(message,
		                      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                      JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPaneArea.setPreferredSize(new Dimension(400, 400));
	

		add(title, BorderLayout.NORTH);
		add(scrollPaneArea, BorderLayout.CENTER);
		
		setForeground(Color.white);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(400, 400));
		setModal(true);
		setResizable(false);
		pack();

		setVisible(true);
	}
}
