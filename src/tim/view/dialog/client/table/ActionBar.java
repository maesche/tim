package tim.view.dialog.client.table;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import tim.application.Config;
import tim.model.Client;
import tim.view.ParentView;

public class ActionBar extends JPanel {
	private JButton btnSave;
	private JButton btnDelete;
	
	private Client client = null;
	private boolean performAction = false;
	
	private ParentView view;


	public ActionBar() {

		setLayout(new FlowLayout());
		btnSave = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogSave"));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (performAction) {
					save();
				}
			}
		});
		btnDelete = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogDelete"));
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (performAction) {
					delete();
				}
			}
		});
		add(btnSave);
		add(btnDelete);
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setPerformAction(boolean performAction) {
		this.performAction = performAction;
	}
	
	private void save() {
		view.save("add", client);
	}
	
	private void delete() {
		view.save("delete", client);
	}
	
	public void setParentView(ParentView view) {
		this.view = view;
	}
}
