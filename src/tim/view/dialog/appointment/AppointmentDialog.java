package tim.view.dialog.appointment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
import tim.model.Person;
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
		init(appointment);
	}
	
	public AppointmentDialog (Employee employee, Date begin, Date end) {
		Appointment appointment = new Appointment(begin, end, null, employee, null);
		System.out.println(appointment);
		init(appointment);
	}
	
	private void init(Appointment appointment) {
		form = new Form();
		form.setParentView(this);
		
		try {
			form.setClients(controller.getAll("client"), null);
			if (appointment != null) {
				form.setClients(controller.getAll("client"), (int)appointment.getClient().getId());
			}
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		form.setData(appointment);
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
				close();
			}
		});
		
		
		btnSave = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogSave"));
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("appointment: " + form.getData());
				if (check((Appointment) form.getData())) {
					save("add", form.getData());
					close();	
				}
			}
		});
		
		btnDelete = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogDelete"));
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (check((Appointment) form.getData())) {
					save("delete", form.getData());
					close();	
				}
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

	private boolean check(Appointment appointment) {
		boolean ret = true;
		if (appointment == null) {
			lblErrorMsg.setText(Config.RESSOURCE_BUNDLE.getString("dialogMessages"));
			ret = false;
		}
		return ret;
	}
	
	private void close() {
		setVisible(false);
		dispose();
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		
	}

	@Override
	public void save(String action, Object value) {
		lblErrorMsg.setText(" ");
		
		try {
			if ("add".equals(action)) {
				boolean ret = ((AppointmentDialogController)controller).checkAvailability((Appointment) value);
				if (ret) {
					System.out.println("Disponible");
					//controller.save(action, (Appointment) value);
				}
				else {
					System.out.println("Pas disponible");
				}
			}
			else if("delete".equals(action)) {
				controller.save(action, (Appointment) value);
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		close();
		
	}
}
