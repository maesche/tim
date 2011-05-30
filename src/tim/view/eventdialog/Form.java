package tim.view.eventdialog;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Form extends JPanel {
	private JLabel lblClient;
	private JComboBox cbClient;
	private JLabel lblDate;
	private JTextField txtDate;
	private JLabel lblBegin;
	private JComboBox cbBeginH;
	private JComboBox cbBeginM;
	private JLabel lblEnd;
	private JComboBox cbEndM;
	private JComboBox cbEndH;
	private JLabel lblDescription;
	private JTextArea txtDescription;
	private JScrollPane spDescription;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnCancel;
	private JPanel buttonPanel;

	public Form() {

		lblClient = new JLabel("Client :");
		cbClient = new JComboBox();
		cbClient.addItem("test1");
		cbClient.addItem("test2");

		lblDate = new JLabel("Date :");
		txtDate = new JTextField(10);

		lblBegin = new JLabel("Begin :");
		cbBeginH = new JComboBox();
		cbBeginM = new JComboBox();

		lblEnd = new JLabel("End :");
		cbEndH = new JComboBox();
		cbEndM = new JComboBox();

		lblDescription = new JLabel("Description :");
		txtDescription = new JTextArea(10, 20);
		spDescription = new JScrollPane();
		spDescription.setViewportView(txtDescription);
		
		buttonPanel = new JPanel();
		btnCancel = new JButton("Canel");
		btnSave = new JButton("Save");
		btnDelete = new JButton("Delete");
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnSave);

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 1;

		/*
		 * Labels
		 */
		gbc.anchor = GridBagConstraints.EAST;
		
		
		gbc.gridy = 4;
		gbc.gridx = 0;
		add(lblDescription, gbc);

		gbc.gridy = 0;
		gbc.gridx = 0;
		add(lblClient, gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(lblDate, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(lblBegin, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(lblEnd, gbc);

		/*
		 * Components
		 */
		gbc.anchor = GridBagConstraints.WEST;

		gbc.gridy = 2;
		gbc.gridx = 1;
		add(cbBeginH, gbc);

		gbc.gridy = 2;
		gbc.gridx = 2;
		add(new JLabel(":"), gbc);

		gbc.gridy = 2;
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(cbBeginM, gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		add(cbEndH, gbc);

		gbc.gridy = 3;
		gbc.gridx = 2;
		add(new JLabel(":"), gbc);

		gbc.gridy = 3;
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(cbEndM, gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(txtDescription, gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(cbClient, gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(txtDate, gbc);

		/*
		 * Buttonpanel
		 */
		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.insets = new Insets(15, 0, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(buttonPanel, gbc);
		
		init();
	}

	public void init() {

		for (int i = 0; i <= 23; i++) {
			cbBeginH.addItem(i);
			cbEndH.addItem(i);
		}

		for (int i = 0; i <= 60; i += 5) {
			cbBeginM.addItem(i);
			cbEndM.addItem(i);
		}
	}
}
