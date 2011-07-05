package tim.view.dialog.client;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * This is a custom model for a JTable
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class CustomTableModel extends AbstractTableModel {

	Vector<String> columnNames = null;
	Vector<Vector<Object>> data = null;

	public void setData(Vector<Vector<Object>> data) {
		this.data = data;
	}
	
	/**
	 * If data changes, table needs to be updated
	 * @param data
	 */
	public void updateData(Vector<Vector<Object>> data) {
		setData(data);
		fireTableDataChanged();
	}
	
	public void setColumnNames(Vector<String> colunmNames) {
		this.columnNames = colunmNames;
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
	
	/**
	 * First row is not editable as it holds the clients id
	 */
	public boolean isCellEditable(int row, int col) {
		return col != 0;
	}
	
	/**
	 * Adds a row at the end of the JTable
	 * @param rowData
	 */
	public void addRow(Vector<Object> rowData) {
		data.add(rowData);
		fireTableDataChanged();
	}
	
	/**
	 * Removes the last row of the JTable
	 * @param row
	 */
	public void removeRow(int row) {
		data.remove(row);
		fireTableDataChanged();
	}
	


}
