package tim.view.dialog.client;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import tim.application.exception.PersistanceException;
import tim.model.Client;
import tim.model.Element;
import tim.view.calendar.ClientDialogController;

public class Form extends JPanel {
	JTable table;
	ClientTableModel clientTableModel = null;
	JButton btnSave;
	JButton btnDelete;
	ActionPanel actionPanel = null;
	
	ClientDialogController clientDialogController;
	
	public Form(ClientDialogController clientDialogController) {
		this.clientDialogController = clientDialogController;


		ArrayList<Element> elements = null;
		try {
			elements = clientDialogController.getClients();
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actionPanel = new ActionPanel();

		Object[][] data = new Object[elements.size() + 1][6];
		String[] columnNames = { 		   "ID","First Name", "LastName",
				   "Address", "Phone", "Action"}; 

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
		actionColumn.setCellRenderer(new ActionPanelRenderer());
		table.getColumnModel().getColumn(5).setCellEditor(new ActionPanelEditor());
		table.getColumnModel().getColumn(5).setWidth(200);
		table.getColumnModel().getColumn(5).setMinWidth(200);
		
		table.setRowHeight(40);
		
		add(table);
	}                     
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
