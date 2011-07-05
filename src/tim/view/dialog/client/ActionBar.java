package tim.view.dialog.client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import tim.application.Config;
import tim.model.Client;
import tim.view.ParentView;

/**
 * Action panel for client dialog
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class ActionBar extends JPanel {
	private JButton btnSave;
	private JButton btnDelete;
	
	private Client client = null;
	private boolean performAction = false;
	private String mode;
	
	private ParentView view;


	public ActionBar() {
		mode = "add";
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
				delete();
				if (performAction) {
					delete();
				}
			}
		});
		add(btnSave);
		add(btnDelete);
	}
	
	/**
	 * Defines what to do
	 * @param mode (save, edit, delete)
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	

	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * Work around to prevent action if button is called accidently or
	 * if values specified contains error
	 */
	public void setPerformAction(boolean performAction) {
		this.performAction = performAction;
	}
	
	private void save() {
		view.save(mode, client);
	}
	
	private void delete() {
		view.save("delete", client);
	}
	
	/**
	 * Needs to know the ParentView which needs to execute the action called
	 * by the user
	 * @param view
	 */
	public void setParentView(ParentView view) {
		this.view = view;
	}
}
