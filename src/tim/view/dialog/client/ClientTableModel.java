package tim.view.dialog.client;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ClientTableModel extends AbstractTableModel {
	Vector<String> columnNames = null;
	Vector<Vector<Object>> data = null;
	
	public ClientTableModel(Vector<Vector<Object>> data, Vector<String> colunmNames) {
		this.columnNames = colunmNames;
		this.data = data;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data.get(row).get(col);
	}
	
	public String getColumnName(int col) { 
		return columnNames.get(col).toString();
	}
	

	public void setValueAt(Object value, int row, int col) {
		Vector<Object> rowData = (Vector<Object>)data.get(row);
        rowData.set(col, value);
		fireTableCellUpdated(row, col);
	}
	
	public boolean isCellEditable(int row, int col) {
		return col != 0;
	}
	
	public void addRow(Vector<Object> rowData) {
		data.add(rowData);
		fireTableDataChanged();
	}
	
	public void removeRow(int row) {
		data.remove(row);
		fireTableDataChanged();
	}
}
