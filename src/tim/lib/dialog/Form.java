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
	private int maxLength; // transform to array with pointer to biggest value
	private int posMaxLength;

	public Form() {
		formEntries = new ArrayList<FormEntry>();
		maxLength = 0;
		posMaxLength = 0;
	}

	public void addEntry(FormEntry formEntry) {
		formEntries.add(formEntry);
		if (formEntry.getLength() > maxLength) {
			maxLength = formEntry.getLength();
			posMaxLength = formEntries.size() - 1;
		}
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
				form.add(entryLabel, gbc);
				x++;	
			}
			
			for (FormComponent formComponent : formEntry.getComponents()) {
				JComponent component = formComponent.getComponent();

				gbc.anchor = GridBagConstraints.WEST;

				gbc.gridx = x;
				form.add(component, gbc);

				x++;
			}
			gbc.gridwidth = GridBagConstraints.REMAINDER;

			y++;
		}

		return form;
	}
}
