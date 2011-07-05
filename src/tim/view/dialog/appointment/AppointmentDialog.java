package tim.view.dialog.appointment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.exception.OperationNotPossibleException;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.AbstractController;
import tim.controller.AppointmentDialogController;
import tim.model.Appointment;
import tim.view.ParentView;

/**
 * This dialog offers the possiblity to change appointments
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class AppointmentDialog extends JDialog implements ActionListener, ParentView {
	Form form = null;
	AbstractController controller = new AppointmentDialogController();
	private JPanel buttonPanel;
	private JButton btnCancel;
	private JButton btnSave;
	private JButton btnDelete;
	private JPanel errorPanel;
	private JLabel lblErrorMsg;
	private String mode = "add";

	public AppointmentDialog(Appointment appointment) {
		errorPanel = new JPanel();
		lblErrorMsg = new JLabel(" ");
		lblErrorMsg.setForeground(Color.RED);

		errorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		errorPanel.add(lblErrorMsg);
		
		buttonPanel = new JPanel();
		btnCancel = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogCancel"));
		btnDelete = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogDelete"));
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		
		form = new Form();
		form.setData(appointment);
		try {
			/*
			 * Retrives informaiton from the controller and forwards it to ChildView
			 */
			if (appointment.getClient() != null) {
				form.setClients(controller.getAll("client"), (int)appointment.getClient().getId());
				mode = "edit";
			} else {
				form.setClients(controller.getAll("client"), null);
				btnDelete.setEnabled(false);
			}
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		btnSave = new JButton(Config.RESSOURCE_BUNDLE.getString("dialogSave"));
		
		/*
		 * If the users wants to save information, the View will ask the Controller if
		 * date and time is available (only for new and editing method)
		 */
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (check((Appointment) form.getData())) {
					Appointment appointment =  (Appointment) form.getData();
					boolean ret;
					try {
						ret = ((AppointmentDialogController)controller).checkAvailability(appointment);
						if (ret) {
							save(mode, appointment);
							close();
						}
						else {
							notAvailable();
						}
					} catch (PersistanceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
		});
		

		
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
	}
	
	public void notAvailable() {
		JOptionPane.showMessageDialog(
				this,
				Config.RESSOURCE_BUNDLE.getString("dialogErrorAppointment"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		close();
	}
}
