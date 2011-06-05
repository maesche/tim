package tim.lib.dialog;

import java.awt.Container;

import javax.swing.JFrame;

import tim.controller.AbstractController;

public class TestDialog extends Dialog {

	public TestDialog(AbstractController controller, JFrame parent, Form form,
			ButtonPanel buttonPanel) {
		super(controller, parent, form, buttonPanel);
		
		Container container = getContentPane();
		
		container.add(form.generate());
	}

}
