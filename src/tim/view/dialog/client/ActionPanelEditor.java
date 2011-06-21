package tim.view.dialog.client;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

import tim.model.Client;

public class ActionPanelEditor extends ActionPanel implements TableCellEditor {
	private ActionPanel actionPanel;

	public ActionPanelEditor(ActionPanel actionPanel) {
		this.actionPanel = actionPanel;
	}
	@Override
	public void addCellEditorListener(CellEditorListener cellEditorListener) {
	}

	@Override
	public void cancelCellEditing() {
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject eventObject) {
		return true;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener cellEditorListener) {
	}

	@Override
	public boolean shouldSelectCell(EventObject eventObject) {
		return false;
	}

	@Override
	public boolean stopCellEditing() {
		return true;
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
		actionPanel.setClient(client);
		if (firstName == null || "".equals(firstName)) {
		buttonPressed(table, row, col);
			actionPanel.setPerformAction(false);
		}
		else {
			actionPanel.setPerformAction(true);
		}

		return actionPanel;
	}

	private void buttonPressed(JTable table, int row, int column) {
		JOptionPane
				.showMessageDialog(table, "Please fill in at least the first and lastname.");
	}
}
