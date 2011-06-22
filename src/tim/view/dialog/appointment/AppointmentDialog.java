package tim.view.dialog.appointment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.OperationNotPossibleException;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.controller.AppointmentDialogController;
import tim.model.Appointment;
import tim.model.Client;
import tim.model.Element;
import tim.model.Employee;
import tim.view.Application;
import tim.view.ParentView;

public class AppointmentDialog extends JDialog implements ActionListener, ParentView {
	Form form = null;
	AbstractController controller = new AppointmentDialogController();
	private JPanel buttonPanel;
	private JButton btnCancel;
	private JButton btnSave;
	private JButton btnDelete;
	private JPanel errorPanel;
	private JLabel lblErrorMsg;

	public AppointmentDialog(Appointment appointment) {
		System.out.println(appointment);
		
		form = new Form();
		form.setParentView(this);
		try {
			form.setClients(controller.getAll("client"), null);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		errorPanel = new JPanel();
		lblErrorMsg = new JLabel(" ");
		lblErrorMsg.setForeground(Color.RED);

		errorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		errorPanel.add(lblErrorMsg);
		
		buttonPanel = new JPanel();
		btnCancel = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogCancel"));
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
		
		
		btnSave = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogSave"));
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				save("add", form.getData());

			}
		});
		
		btnDelete = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogDelete"));
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
		
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnSave);

		setTitle("TIM - Appointment");

		add(errorPanel, BorderLayout.NORTH);
		add(form, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public AppointmentDialog (Employee employee, Date begin, Date end) {
		System.out.println(employee + " " + begin + " " + end);
	}

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String action, Object value) {
		lblErrorMsg.setText(" ");
		/*if (!(AppointmentDialogValidator.dateField(lblDate, txtDate) && AppointmentDialogValidator
				.startEnd(lblBegin, lblEnd, beginH, beginM, endH, endM))) {
			lblErrorMsg.setText("Please check the following errors: ");

		} else {

		}*/
		try {
			controller.save(action, (Appointment) value);
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
			
		
		//close dialog
	}
}
