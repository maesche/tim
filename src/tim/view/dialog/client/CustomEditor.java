package tim.view.dialog.client;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import tim.application.Config;
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
		String address = String.valueOf(table.getModel().getValueAt(row, 3));
		String phone = String.valueOf(table.getModel().getValueAt(row, 4));


		Client client = new Client(id, firstName, lastName, phone, address,
				null);

		if (id > -1) {
			renderer.setMode("edit");
		}
		else {
			renderer.setMode("add");
		}
		renderer.setClient(client);
		if (firstName == null || "".equals(firstName) || lastName == null || "".equals(lastName) /*|| check for numeric(phone != null && phone.i)*/) {
			buttonPressed(table, row, col);
			renderer.setPerformAction(false);
		} else {
			renderer.setPerformAction(true);
		}

		return renderer;
	}

	private void buttonPressed(JTable table, int row, int column) {
		JOptionPane.showMessageDialog(table,
				Config.RESSOURCE_BUNDLE.getString("dialogErrorClient"));
	}

}
