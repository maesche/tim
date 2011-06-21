package tim.view.dialog.client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.controller.ClientDialogController;
import tim.model.Client;

public class ActionPanel extends JPanel {
	private JButton btnSave;
	private JButton btnDelete;
	
	private Client client = null;
	private boolean performAction = false;
	
	private ClientDialog clientDialog;


	public ActionPanel() {

		this.setLayout(new FlowLayout());
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
		
		clientDialog.save("add", client);
	}
	
	private void delete() {
		clientDialog.save("delete", client);
	}
	
	public void setMainView(ClientDialog main) {
		this.clientDialog = main;
	}
}
