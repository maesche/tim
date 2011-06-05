package tim.view.appointmentdialog;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tim.application.Config;
import tim.view.appointmentdialog.AppointmentDialogValidator;

public class Form extends JPanel {
	private JLabel lblErrorMsg;
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
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnCancel;
	private JPanel buttonPanel;
	private JPanel errorPanel;

	public Form() {
		errorPanel = new JPanel();
		lblErrorMsg = new JLabel (" ");
		lblErrorMsg.setForeground(Color.RED);

		
		errorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		errorPanel.add(lblErrorMsg);
		

		
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
		//txtDescription.setBorder(BorderFactory.createCompoundBorder());
		
		buttonPanel = new JPanel();
		btnCancel = new JButton("Cancel");
		btnSave = new JButton("Save");
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				validate();	
			}
		});
		
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
		
		
		gbc.gridy = 5;
		gbc.gridx = 0;
		add(lblDescription, gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		add(lblClient, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(lblDate, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(lblBegin, gbc);

		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(lblEnd, gbc);

		/*
		 * Components
		 */
		gbc.anchor = GridBagConstraints.WEST;

		gbc.gridy = 3;
		gbc.gridx = 1;
		add(cbBeginH, gbc);

		gbc.gridy = 3;
		gbc.gridx = 2;
		add(new JLabel(":"), gbc);

		gbc.gridy = 3;
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(cbBeginM, gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		add(cbEndH, gbc);

		gbc.gridy = 4;
		gbc.gridx = 2;
		add(new JLabel(":"), gbc);

		gbc.gridy = 4;
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(cbEndM, gbc);

		gbc.gridy = 5;
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(txtDescription, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(cbClient, gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(txtDate, gbc);

		/*
		 * Buttonpanel
		 */
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.insets = new Insets(15, 0, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(buttonPanel, gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(15, 0, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(errorPanel, gbc);
		
		
		init();
	}

	public void init() {

		for (int i = Config.CALENDAR_DAY_START; i <= Config.CALENDAR_DAY_END; i++) {
			cbBeginH.addItem(i);
			cbEndH.addItem(i);
		}

		for (int i = 0; i < 60; i += Config.CALENDAR_DAY_INTERVAL) {
			cbBeginM.addItem(i);
			cbEndM.addItem(i);
		}
	}
	
	public void validate() {
		/*
		 * private JComboBox cbClient;

	private JTextField txtDate;

	private JComboBox cbBeginH;
	private JComboBox cbBeginM;

	private JComboBox cbEndM;
	private JComboBox cbEndH;

	private JTextArea txtDescription;

		 */
		int beginH = 0, endH = 0, beginM = 0, endM = 0;
		
		beginH = (Integer)cbBeginH.getSelectedItem();
		endH = (Integer) cbEndH.getSelectedItem();
		beginM = (Integer) cbBeginM.getSelectedItem();
		endM = (Integer) cbEndM.getSelectedItem();
		
		
		
		lblErrorMsg.setText(" ");
		if (!(AppointmentDialogValidator.dateField(lblDate, txtDate) && AppointmentDialogValidator.startEnd(beginH, beginM, endH, endM))) {
			lblErrorMsg.setText("Please check the following errors: ");
		}


	}
}
