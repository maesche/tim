package tim.lib.dialog;

import java.util.ArrayList;

import javax.swing.JLabel;
/*
 * FormEntry = line in a form
 */
public class FormEntry {
	private ArrayList<FormComponent> formComponents;
	private int order;
	private JLabel label;
	
	public FormEntry(int order, JLabel label) {
		this.order = order;
		this.label = label;
		init();

	}
	
	public FormEntry(JLabel label) {
		this.label = label;
		init();
	}
	
	public FormEntry() {
		init();
	}
	
	private void init() {
		formComponents = new ArrayList<FormComponent>();
	}
	
	public void addComponent(FormComponent formComponent) {
		formComponents.add(formComponent);

	}
	
	public void removeComponent(FormComponent formComponent) {
		formComponents.remove(formComponent);

	}
	

	public int getOrder() {
		return order;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public ArrayList<FormComponent> getComponents() {
		return  formComponents;
	}
}
