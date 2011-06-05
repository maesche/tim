package tim.lib.dialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
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
			gbc.gridwidth = 1;
			gbc.gridy = y;
			x = 0;
			
			JLabel entryLabel = formEntry.getLabel();
			if (entryLabel != null) {
				gbc.anchor = GridBagConstraints.EAST;
				gbc.gridx = x;
				form.add(entryLabel);
				System.out.println("y: " + y + " | x: " + x);
				x++;
				
			}
			
			for (FormComponent formComponent : formEntry.getComponents()) {
				JComponent component = formComponent.getComponent();
				JLabel label = formComponent.getLabel();
				
				
				if (label != null) {
					gbc.gridx = x;
					form.add(label);
					x++;
				}
				gbc.anchor = GridBagConstraints.WEST;
				gbc.gridx = x;
				form.add(component);
				System.out.println("y: " + y + " | x: " + x);

				x++;
			}
			gbc.gridwidth = GridBagConstraints.REMAINDER;

			y++;
		}

		return form;
	}
}
