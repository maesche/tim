package tim.view.dialog.client;

import javax.swing.table.AbstractTableModel;

public class ClientTableModel extends AbstractTableModel {
	String[] columnNames = null; 
	Object[][] data = null;
	
	public ClientTableModel(Object[][] data, String[] colunmNames) {
		this.columnNames = colunmNames;
		this.data = data;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public String getColumnName(int col) { 
		return columnNames[col].toString();
	}
	

	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	public boolean isCellEditable(int row, int col) {
		return col != 0;
	}
}
