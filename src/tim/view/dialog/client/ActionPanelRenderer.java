package tim.view.dialog.client;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class ActionPanelRenderer extends ActionPanel implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		return this;
	}
	


}