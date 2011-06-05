package tim.lib.dialog;

import java.util.ArrayList;
/*
 * FormEntry = line in a form
 */
public class FormEntry {
	private ArrayList<FormComponent> formComponents;
	private int size;
	
	public FormEntry() {
		formComponents = new ArrayList<FormComponent>();
		size = 0;
	}
	
	public void addEntry(FormComponent formComponent) {
		formComponents.add(formComponent);
		size++;
	}
	
	public void removeEntry(FormComponent formComponent) {
		formComponents.remove(formComponent);
		size--;
	}
	
	public int getSize() {
		return size;
	}
	
	public ArrayList<FormComponent> getComponents() {
		return  formComponents;
	}
}
