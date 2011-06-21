package tim.view.dialog.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JDialog;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.controller.ClientDialogController;
import tim.model.Element;
import tim.view.AbstractView;

public class ClientDialog extends JDialog implements AbstractView {
	Form form;
	ClientDialogController clientDialogController;
	private JButton btnCancel;
	private ClientDialogController controller;
	
	public ClientDialog(ClientDialogController controller) {
		this.controller = (ClientDialogController) controller;
		try {
			form = new Form(controller.getAll("clients"), this);
		} catch (PersistanceException e) {
			e.printStackTrace();
		}
		
		try {
			GlobalRegistry.mvcLinker.addObserverToModel("ClientModel", this);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnCancel = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogCancel"));
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
			
		});
		
		add(form, BorderLayout.NORTH);
		add(btnCancel, BorderLayout.CENTER);
	}
	
	public void save(String action, Element element) {
		try {
			controller.save(action, element);
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	
	private void close() {
		this.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			form = new Form(controller.getAll("clients"), this);
			repaint();
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("reload");
	}


}
