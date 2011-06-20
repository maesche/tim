package tim.view.dialog.client;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class ActionPanelRenderer implements TableCellRenderer {


	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component component = null;
		if (value instanceof JPanel) {
			component = (JPanel) value;

		} 
		return component;
	}

}