package tim.view.dialog.client;

import java.util.EventObject;

import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

abstract public class AbstractCellEditor implements TableCellEditor {

	@Override
	public void addCellEditorListener(CellEditorListener cellEditorListener) {
		System.out.println("addCellEditorListener");
	}

	@Override
	public void cancelCellEditing() {
		System.out.println("cancel");
	}

	@Override
	public Object getCellEditorValue() {
		System.out.println("getCellEditorValue");
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject eventObject) {
		System.out.println("editable");
		return true;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener cellEditorListener) {
	}

	@Override
	public boolean shouldSelectCell(EventObject eventObject) {
		System.out.println("should select");
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		System.out.println("stop editing");
		return true;
	}
}
