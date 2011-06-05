package tim.lib.dialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import tim.lib.dialog.FormComponent;

public class Form {
	private ArrayList<FormEntry> formEntries;
	
	public Form() {
		formEntries = new ArrayList<FormEntry>();
	}
	
	public void addEntry(FormEntry formEntry) {
		formEntries.add(formEntry);
	}
	
	public void removeEntry(FormComponent formEntry) {
		formEntries.remove(formEntry);
	}
	
	public JPanel generate() {
		JPanel form = new JPanel();
		
		form.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 1;

		gbc.anchor = GridBagConstraints.EAST;

		
		int x = 0;
		int y = 0;
		for (FormEntry formEntry : formEntries) {
			
			for (FormComponent formComponent : formEntry.getComponents()) {

			gbc.gridy = y;
			gbc.gridx = x;
			form.add(formComponent.getComponent());
			gbc.gridx = x;
			form.add(formComponent.getLabel());
			}
			
			y++;
		}
		
		return form;
	}
}
