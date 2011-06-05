package tim.lib.dialog;

import java.util.ArrayList;

import javax.swing.JLabel;
/*
 * FormEntry = line in a form
 */
public class FormEntry {
	private ArrayList<FormComponent> formComponents;
	private int length;
	private JLabel label;
	

	
	public FormEntry(JLabel label) {
		this.label = label;
		init();
	}
	
	public FormEntry() {
		init();
	}
	
	private void init() {
		formComponents = new ArrayList<FormComponent>();
		length = 0;
	}
	
	public void addComponent(FormComponent formComponent) {
		formComponents.add(formComponent);
		length++;

	}
	
	public void removeComponent(FormComponent formComponent) {
		formComponents.remove(formComponent);
		length--;

	}
	

	public int getLength() {
		return length;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public ArrayList<FormComponent> getComponents() {
		return  formComponents;
	}
}
