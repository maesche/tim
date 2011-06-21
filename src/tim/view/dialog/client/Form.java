package tim.view.dialog.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import tim.application.exception.PersistanceException;
import tim.controller.AbstractController;
import tim.controller.ClientDialogController;
import tim.model.Client;
import tim.model.Element;

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
	private ClientDialogController controller;
	

	public Form(ClientDialogController clientDialogController) {
		controller = clientDialogController;
		ArrayList<Element> elements = null;
		try {
			elements = controller.getAll("clients");
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionPanel = new ActionPanel();

		data = new Object[elements.size() + 1][6];

		int nb = 0;
		
		for (Element element : elements) {
			Client client = (Client) element;

			data[nb][0] = (int) client.getId();
			data[nb][1] = client.getFirstName();
			data[nb][2] = client.getLastName();
			data[nb][3] = client.getAddress();
			data[nb][4] = client.getPhone();
			data[nb][5] = actionPanel;
				nb++;
		}
		data[nb][0] =  null;
		data[nb][1] =  null;
		data[nb][2] =  null;
		data[nb][3] =  null;
		data[nb][4] =  null;
		data[nb][5] =  actionPanel;

		clientTableModel = new ClientTableModel(data, columnNames);
		table = new JTable(clientTableModel);

		TableColumn actionColumn = table.getColumn(columnNames[5]);
		TableCellEditor editor = new ActionPanelEditor();
		TableCellRenderer renderer = new ActionPanelRenderer();
		
		actionColumn.setCellRenderer(renderer);
		actionColumn.setCellEditor(editor);

		
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(200);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(280);

		table.setRowHeight(rowHeight);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(table);
		
		this.setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(780, nb * rowHeight + 120));
	}             
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
