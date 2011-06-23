package tim.view.dialog.client;

import java.awt.BorderLayout;

import java.util.Observable;
import java.util.Vector;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.ResourceNotFoundException;
import tim.model.Client;
import tim.model.Element;
import tim.view.AbstractView;

public class Form extends JPanel {
	private Vector<Vector<Object>> data;
	private Vector<String> columnNames;
	private JTable table;
	private ClientTableModel clientTableModel = null;
	private int rowHeight = 40;
	TableCellRenderer renderer;

	public Form(ArrayList<Element> elements, ClientDialog main) {
		load(elements, main);

	}

	private void load(ArrayList<Element> elements, ClientDialog main) {

		renderer = new ActionPanelRenderer();
		TableCellEditor editor = new ActionPanelEditor(main);

		data = new Vector<Vector<Object>>();
		columnNames = new Vector<String>();
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personId"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personFirstname"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personLastname"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personAddress"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personPhone"));
		columnNames.add("Action");

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

		clientTableModel = new ClientTableModel(data, columnNames);

		table = new JTable(clientTableModel);

		TableColumn actionColumn = table.getColumn(columnNames.get(5));


		
		((ActionPanelRenderer) renderer).setMainView(main);

		actionColumn.setCellRenderer(renderer);
		actionColumn.setCellEditor(editor);

		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(200);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(280);

		table.setRowHeight(rowHeight);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(table);

		JButton addRow = new JButton("Add blank row");
		addRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addRow();
			}
		});

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		add(addRow, BorderLayout.NORTH);
		setPreferredSize(new Dimension(800, data.size() * rowHeight + 250));
	}

	public void addRow() {
		Vector<Object> rowData = new Vector<Object>();
		rowData.add((Integer) null);
		rowData.add((String) null);
		rowData.add((String) null);
		rowData.add((String) null);
		rowData.add((String) null);
		rowData.add(renderer);

		clientTableModel.addRow(rowData);
	}
}
