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
	private JLabel lblBegin;
	private JComboBox cbBeginH;
	private JComboBox cbBeginM;
	private JLabel lblEnd;
	private JComboBox cbEndM;
	private JComboBox cbEndH;

	public Form() {

		lblClient = new JLabel("Client");
		cbClient = new JComboBox();
		cbClient.addItem("test1");
		cbClient.addItem("test2");

		lblDate = new JLabel("Date");
		txtDate = new JTextField(10);
		
		lblBegin = new JLabel("Begin");
		cbBeginH = new JComboBox();
		cbBeginM = new JComboBox();
		
		lblEnd = new JLabel("End");
		cbEndH = new JComboBox();
		cbEndM = new JComboBox();

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
		
		gbc.gridwidth = 1;
		add(lblBegin, gbc);

		add(Box.createHorizontalStrut(10));
		add(cbBeginH, gbc);
		add(Box.createHorizontalStrut(10));
		add(new JLabel(":"), gbc);
		add(Box.createHorizontalStrut(10));
		add(cbBeginM, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		add(lblEnd, gbc);

		add(Box.createHorizontalStrut(10));
		add(cbEndH, gbc);
		add(Box.createHorizontalStrut(10));
		add(new JLabel(":"), gbc);
		add(Box.createHorizontalStrut(10));
		add(cbEndM, gbc);

		init();
	}
	
	public void init() {
		
		for (int i = 0; i <= 23; i++) {
			cbBeginH.addItem(i);
			cbEndH.addItem(i);
		}
		
		for (int i = 0 ; i <= 60; i += 5) {
			cbBeginM.addItem(i);
			cbEndM.addItem(i);
		}
	}
}
