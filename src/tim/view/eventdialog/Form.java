package tim.view.eventdialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form extends JPanel {
	private JLabel lblClient;
	private JComboBox cbClient;
	private JLabel lblDate;
	private JTextField txtDate;

	public Form() {

		lblClient = new JLabel("Client");
		cbClient = new JComboBox();
		cbClient.addItem("test1");
		cbClient.addItem("test2");

		lblDate = new JLabel("Date");
		txtDate = new JTextField(25);

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		setLayout(gbl);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lblClient, gbc);

		add(Box.createHorizontalStrut(10));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(cbClient, gbc);

		gbc.gridwidth = 1;
		add(lblDate, gbc);

		add(Box.createHorizontalStrut(10));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(txtDate, gbc);

	}
}
