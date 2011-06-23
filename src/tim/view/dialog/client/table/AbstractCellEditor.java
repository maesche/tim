package tim.view.dialog.client.table;

import java.util.EventObject;

import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

abstract public class AbstractCellEditor implements TableCellEditor {

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
}
