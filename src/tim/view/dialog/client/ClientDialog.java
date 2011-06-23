package tim.view.dialog.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JDialog;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.OperationNotPossibleException;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.model.Element;
import tim.view.ParentView;

public class ClientDialog extends JDialog implements ParentView {
	Form form;
	private JButton btnCancel;
	private AbstractController controller;
	
	public ClientDialog(AbstractController controller) {
		try {
			GlobalRegistry.mvcLinker.addObserverToModel("ClientModel", this);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.controller = controller;
		try {
			form = new Form(controller.getAll("client"), this);
		} catch (PersistanceException e) {
			e.printStackTrace();
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
		this.pack();
	}
	
	private void close() {
		this.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			this.remove(form);
			this.remove(btnCancel);
			form = new Form(controller.getAll("client"), this);
			add(form, BorderLayout.NORTH);
			add(btnCancel, BorderLayout.CENTER);
			this.pack();

		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(String action, Object value) {
		try {
			controller.save(action, (Element)value);
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationNotPossibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
