package tim.view.dialog.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
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
	
	JPanel action;
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
		

		

		Object[][] data = new Object[elements.size() + 1][6];
		String[] columnNames = { 		   "ID","First Name", "LastName",
				   "Address", "Phone", "Action"}; 


		
		int nb = 0;
		action = new JPanel(new FlowLayout());
		btnSave = new JButton("Save");
		btnDelete = new JButton("Delete");
		action.add(btnSave);
		action.add(btnDelete);
		
		for (Element element : elements) {
			Client client = (Client) element;


			
			data[nb][0] = client.getId();
			data[nb][1] = client.getFirstName();
			data[nb][2] = client.getLastName();
			data[nb][3] = client.getAddress();
			data[nb][4] = client.getPhone();
			data[nb][5] = btnSave;
				nb++;
		}
		data[nb][0] =  null;
		data[nb][1] =  null;
		data[nb][2] =  null;
		data[nb][3] =  null;
		data[nb][4] =  null;
		data[nb][5] =  btnSave;


		clientTableModel = new ClientTableModel(data, columnNames);
		table = new JTable(clientTableModel);
		TableColumn actionColumn = table.getColumn("Action");
		actionColumn.setCellRenderer(new ActionPanelRenderer());
		add(table);
	}                     
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
