package tim.view.dialog.client;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.OperationNotPossibleException;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.model.Element;
import tim.view.ParentView;

public class ClientDialog extends JDialog implements ParentView {
	CustomTable table;
	private JButton btnCancel;
	private AbstractController controller;
	private JButton addRow;
	
	public ClientDialog(AbstractController controller) {
		try {
			GlobalRegistry.mvcLinker.addObserverToModel("ClientModel", this);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		this.controller = controller;
		table = new CustomTable();
		table.setEditor(new CustomEditor(this));
		table.setModel(new CustomTableModel());
		table.setRenderer(new CustomRenderer());
		

		
		ArrayList<Element> elements = null;
		
		try {
			elements = controller.getAll("client");
		} catch (PersistanceException e) {
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vector<String> columnNames = new Vector<String>();
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personId"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personFirstname"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personLastname"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personAddress"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("personPhone"));
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("dialogAction"));
		
		Vector<Integer> columnWidth = new Vector<Integer>();
		columnWidth.add(40);
		columnWidth.add(100);
		columnWidth.add(100);
		columnWidth.add(200);
		columnWidth.add(100);
		columnWidth.add(300);
		
		table.setColumnWidth(columnWidth);
		table.setRowHeight(40);
		
		table.setColumnNames(columnNames);
		table.setData(elements);
		table.load();
		
		addRow = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogAddBlankRow"));
		addRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table.addRow(null);
			}
		});
		
		btnCancel = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogCancel"));
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});

		add(addRow, BorderLayout.NORTH);
		add(table, BorderLayout.CENTER);
		add(btnCancel, BorderLayout.SOUTH);
		this.pack();
	}
	
	private void close() {
		this.setVisible(false);
		this.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		table.addRow(null);
	}

	@Override
	public void save(String action, Object value) {
		try {
			if ("add".equals(action)) {
				controller.save(action, (Element)value);
			}
			else if ("delete".equals(action)) {
				controller.save(action, (Element)value);
			}
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationNotPossibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
