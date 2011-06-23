package tim.view.dialog.client.table;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import tim.model.Client;
import tim.view.ParentView;

public class CustomEditor extends AbstractCellEditor {

	CustomRenderer renderer = new CustomRenderer();

	public CustomEditor(ParentView view) {
		renderer.setParentView(view);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean hasFocus, int row, int col) {
		int id = -1;
		new String();
		if (table.getModel().getValueAt(row, 0) != null) {
			id = (Integer) table.getModel().getValueAt(row, 0);
		}

		String firstName = (String) table.getModel().getValueAt(row, 1);
		String lastName = (String) table.getModel().getValueAt(row, 2);
		String phone = String.valueOf(table.getModel().getValueAt(row, 3));
		String address = String.valueOf(table.getModel().getValueAt(row, 4));

		Client client = new Client(id, firstName, lastName, phone, address,
				null);
		renderer.setClient(client);
		if (firstName == null || "".equals(firstName)) {
			buttonPressed(table, row, col);
			renderer.setPerformAction(false);
		} else {
			renderer.setPerformAction(true);
		}

		return renderer;
	}

	private void buttonPressed(JTable table, int row, int column) {
		JOptionPane.showMessageDialog(table,
				"Please fill in at least the first and lastname.");
	}

}