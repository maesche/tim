package tim.view.dialog.client.table;


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
		data = new Vector<Vector<Object>>();
		columnNames = new Vector<String>();
		setPreferredSize(new Dimension(800, data.size() * rowHeight + 150));
	}
	
	

	public void load() {
		int preferredSize = 0;
		model.setData(data);
		model.setColumnNames(columnNames);

		table = new JTable(model);

		TableColumn actionColumn = table.getColumn(columnNames.get(5));
	
		((CustomRenderer) renderer).setParentView(view);

		actionColumn.setCellRenderer(renderer);
		actionColumn.setCellEditor(editor);
		
		for (int i = 0; i < columnWidth.size(); i++) {
			table.getColumnModel().getColumn(i).setMinWidth(columnWidth.get(i));
			preferredSize += columnWidth.get(i);
		}

		table.setRowHeight(rowHeight);
		table.getTableHeader().setReorderingAllowed(false);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.NORTH);
		setPreferredSize(new Dimension(preferredSize, data.size() * rowHeight + 150));
	}

	public void addBlankRow() {
		Vector<Object> rowData = new Vector<Object>();
		rowData.add((Integer) null);
		rowData.add((String) null);
		rowData.add((String) null);
		rowData.add((String) null);
		rowData.add((String) null);
		rowData.add(renderer);

		model.addRow(rowData);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParentView(ParentView view) {
		this.view = view;
		
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(Object value) {
		@SuppressWarnings("unchecked")
		ArrayList<Element> elements = (ArrayList<Element>) value;
		
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
}
