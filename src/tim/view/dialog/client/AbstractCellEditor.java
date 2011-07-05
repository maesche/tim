package tim.view.dialog.client;

import java.util.EventObject;

import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 * This class replaces the default TableCellEditor
 * It's main objective is to disable events on the current
 * table cell
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public abstract class AbstractCellEditor implements TableCellEditor {

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
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		return true;
	}
}
