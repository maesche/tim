package tim.view.dialog.client;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import tim.model.Client;
import tim.model.Element;
import tim.view.ChildView;
import tim.view.ParentView;

/**
 * This class holds a custom JTable. It is only a container.
 * All data and other informations are provided from ParentView
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class CustomTable extends JPanel implements ChildView {
	private Vector<Vector<Object>> data;
	private Vector<String> columnNames;
	private Vector<Integer> columnWidth;
	private JTable table;

	private CustomTableModel model = null;
	private int rowHeight;

	TableCellRenderer renderer;
	TableCellEditor editor;
	private ParentView view;

	public CustomTable() {
		columnNames = new Vector<String>();
	}
	
	public void load() {
		int preferredSize = 0;
		model.setData(data);
		model.setColumnNames(columnNames);

		table = new JTable(model);

		TableColumn actionColumn = table.getColumn(columnNames.get(5));
	
		((CustomRenderer) renderer).setParentView(view);

		editor.addCellEditorListener(table);
		actionColumn.setCellRenderer(renderer);
		actionColumn.setCellEditor(editor);
		
		/*
		 * Sets the appropriated column width for every column specified
		 * in columnWidth Vector
		 */
		if (columnWidth.size() == columnNames.size()) {
			for (int i = 0; i < columnWidth.size(); i++) {
				table.getColumnModel().getColumn(i).setMinWidth(columnWidth.get(i));
				preferredSize += columnWidth.get(i);
			}
		}
		else {
			preferredSize = 800;
		}

		table.setRowHeight(rowHeight);
		table.getTableHeader().setReorderingAllowed(false);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		/*
		 * Size of this Panel is equal to the number of rows
		 */
		setPreferredSize(new Dimension(preferredSize, data.size() * rowHeight + 150));
	}

	public void addRow(Vector<Object> rowData) {
		if (rowData == null) {
			rowData = new Vector<Object>();
			rowData.add((Integer) null);
			rowData.add((String) null);
			rowData.add((String) null);
			rowData.add((String) null);
			rowData.add((String) null);
			rowData.add(renderer);
		}

		model.addRow(rowData);
	}

	@Override
	public void update(Observable o, Object arg) {		
	}

	@Override
	public void setParentView(ParentView view) {
		this.view = view;
		
	}

	@Override
	public Object getData() {
		return null;
	}

	@Override
	public void setData(Object value) {
		createData(value);
	}
	
	public void setColumnNames(Vector<String> columnNames) {
		this.columnNames = columnNames;
	}
	
	public void setModel (CustomTableModel model) {
		this.model = model;
	}
	
	public void setRenderer (CustomRenderer renderer) {
		this.renderer = renderer;
	}
	
	public void setEditor(CustomEditor editor) {
		this.editor = editor;
	}
	
	public void setColumnWidth(Vector<Integer> columnWidth) {
		this.columnWidth = columnWidth;
	}
	
	public void setRowHeight(int rowHeight) {
		this.rowHeight = rowHeight;
	}
	
	public void removeRow(int row) {
		System.out.println(row);
		model.removeRow(row);
	}
	/**
	 * Transforms specified value to represent in JTable
	 * @param value
	 */
	public void createData(Object value) {
		@SuppressWarnings("unchecked")
		ArrayList<Element> elements = (ArrayList<Element>) value;
		data = new Vector<Vector<Object>>();
		Vector<Object> rowData;

		for (Element element : elements) {
			Client client = (Client) element;
			rowData = new Vector<Object>();
			rowData.add((int) client.getId());
			rowData.add((String) client.getFirstName());
			rowData.add((String) client.getLastName());
			rowData.add((String) client.getAddress());
			rowData.add((String) client.getPhone());
			rowData.add(renderer);
			data.add(rowData);
		}
	}
	
	/**
	 * If called, data has probably changed an the Model needs to be updated
	 * @param value
	 */
	public void update(Object value) {
		createData(value);
		model.updateData(data);
	}
}
