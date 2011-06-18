package tim.lib.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;

import tim.controller.AbstractController;

public abstract class Dialog extends JDialog {
	ButtonPanel buttonPanel = null;
	JFrame parent = null;
	Form form = null;
	AbstractController controller = null;
	
	public Dialog(AbstractController controller, JFrame parent, Form form, ButtonPanel buttonPanel) {
		this.controller = controller;
		this.parent = parent;
		this.form = form;
		this.buttonPanel = buttonPanel;
	}
	
	
}
