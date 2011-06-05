package tim.lib.dialog;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class FormComponent {
	private JLabel label;
	private JComponent component;
	
	public FormComponent(JLabel label, JComponent component) {
		this.label = label;
		this.component = component;
	}
	
	public FormComponent(JComponent component) {
		this.component = component;
	}

	
	public JLabel getLabel() {
		return label;
	}
	public JComponent getComponent() {
		return component;
	}
	
	
}
