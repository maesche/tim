package tim.view.dialog.client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.model.Client;
import tim.view.calendar.ClientDialogController;

public class ActionPanel extends JPanel {
	private JButton btnSave;
	private JButton btnDelete;
	
	private Client client = null;
	private boolean performAction = false;


	public ActionPanel() {

		this.setLayout(new FlowLayout());
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (performAction) {
					save();
				}
			}
		});
		btnDelete = new JButton("Delete");
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

		/*try {
			this.clientDialogController.save(client);
			
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	private void delete() {
		System.out.println("----");
		System.out.println("delete " + client + " perform " + performAction);
		System.out.println("----");
	}
}
