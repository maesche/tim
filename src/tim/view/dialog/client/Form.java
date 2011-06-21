package tim.view.dialog.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.controller.ClientDialogController;
import tim.model.Client;
import tim.model.Element;
import tim.view.AbstractView;

public class Form extends JPanel {
	private Object[][] data;
	private String[] columnNames = {Config.RESSOURCE_BUNDLE.getString("personId"),
			Config.RESSOURCE_BUNDLE.getString("personFirstname"), 
			Config.RESSOURCE_BUNDLE.getString("personLastname"),
			Config.RESSOURCE_BUNDLE.getString("personAddress"), 
			Config.RESSOURCE_BUNDLE.getString("personPhone"), "Action"}; 
	private JTable table;
	private ClientTableModel clientTableModel = null;
	private ActionPanel actionPanel = null;
	private int rowHeight = 40;

	public Form(ArrayList<Element> elements, ClientDialog main) {
		System.out.println(elements.size());
		load(elements, main);
		
	}
	
	private void load(ArrayList<Element> elements, ClientDialog main) {
		TableCellRenderer renderer = new ActionPanelRenderer();
		TableCellEditor editor = new ActionPanelEditor(main);


		data = new Object[elements.size() + 1][6];

		int nb = 0;
		
		for (Element element : elements) {
			Client client = (Client) element;

			data[nb][0] = (int) client.getId();
			data[nb][1] = (String) client.getFirstName();
			data[nb][2] = (String) client.getLastName();
			data[nb][3] = (String) client.getAddress();
			data[nb][4] = (String) client.getPhone();
			data[nb][5] = renderer;
				nb++;
		}
		data[nb][0] =  (Integer) null;
		data[nb][1] =  (String) null;
		data[nb][2] =  (String) null;
		data[nb][3] =  (String) null;
		data[nb][4] =  (String) null;
		data[nb][5] =  renderer;

		clientTableModel = new ClientTableModel(data, columnNames);
		table = new JTable(clientTableModel);

		TableColumn actionColumn = table.getColumn(columnNames[5]);

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
		
		this.setLayout(new BorderLayout());
		add(scrollPane);
		this.setPreferredSize(new Dimension(800, nb * rowHeight + 120));
	}
         
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
