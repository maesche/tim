package tim.view.dialog.client;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import tim.model.Client;

public class ActionPanelEditor extends AbstractCellEditor {
	private ActionPanelRenderer renderer = new ActionPanelRenderer();

	public ActionPanelEditor() {
		
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
		String phone = (String) table.getModel().getValueAt(row, 2);
		String address = (String) table.getModel().getValueAt(row, 2);
		String comment = (String) table.getModel().getValueAt(row, 2);
		Client client = new Client(id, firstName, lastName, phone, address,
				comment);
		renderer.setClient(client);
		if (firstName == null || "".equals(firstName)) {
		buttonPressed(table, row, col);
			renderer.setPerformAction(false);
		}
		else {
			renderer.setPerformAction(true);
		}

		return renderer;
	}

	private void buttonPressed(JTable table, int row, int column) {
		JOptionPane
				.showMessageDialog(table, "Please fill in at least the first and lastname.");
	}
}
