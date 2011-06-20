package tim.view.dialog.client;

import javax.swing.JDialog;

import tim.view.calendar.ClientDialogController;

public class ClientDialog extends JDialog {
	Form form;
	ClientDialogController clientDialogController;
	
	public ClientDialog(ClientDialogController clientDialogController) {
		this.clientDialogController = clientDialogController;
		form = new Form(clientDialogController);
		add(form);
	}
}
