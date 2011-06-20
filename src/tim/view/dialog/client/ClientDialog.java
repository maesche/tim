package tim.view.dialog.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import tim.view.calendar.ClientDialogController;

public class ClientDialog extends JDialog {
	Form form;
	ClientDialogController clientDialogController;
	private JButton btnCancel;
	
	public ClientDialog(ClientDialogController clientDialogController) {
		this.clientDialogController = clientDialogController;
		form = new Form(clientDialogController);
		
		btnCancel = new JButton("Cancel");
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
			
		});
		
		add(form, BorderLayout.NORTH);
		add(btnCancel, BorderLayout.CENTER);
	}
	
	private void close() {
		this.dispose();
	}
}
