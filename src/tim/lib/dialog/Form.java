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
	private int maxLength;

	public Form() {
		formEntries = new ArrayList<FormEntry>();
		maxLength = 0;
	}

	public void addEntry(FormEntry formEntry) {
		formEntries.add(formEntry);
		if (formEntry.getLength() > maxLength) {
			maxLength = formEntry.getLength();
			
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

		gbc.anchor = GridBagConstraints.EAST;
		for (FormEntry formEntry : formEntries) {
			JLabel entryLabel = formEntry.getLabel();

			
			gbc.gridy = y;
			gbc.gridx = x;
			form.add(entryLabel, gbc);
			System.out.println("y: " + y + " | x: " + x);

			y++;
		}
		y = 0;
		gbc.anchor = GridBagConstraints.WEST;
		for (FormEntry formEntry : formEntries) {

			gbc.gridy = y;
			x = 1;
			for (FormComponent formComponent : formEntry.getComponents()) {
				JComponent component = formComponent.getComponent();

				

				gbc.gridx = x;
				form.add(component, gbc);
				System.out.println("y: " + y + " | x: " + x);

				x++;
			}
			if (formEntry.getLength() < maxLength) {
				gbc.gridx = x;
				form.add(new JLabel(), gbc);
				x++;
			}
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			y++;
		}

		return form;
	}
}
