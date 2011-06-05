package tim.lib.dialog;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class FormComponent {

	private JComponent component;
	
	public FormComponent(JComponent component) {
		this.component = component;
	}

	
	public JComponent getComponent() {
		return component;
	}
		
}
