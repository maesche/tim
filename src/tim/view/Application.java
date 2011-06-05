package tim.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import tim.application.utils.ErrorHandler;
import tim.lib.dialog.Form;
import tim.lib.dialog.FormComponent;
import tim.lib.dialog.FormEntry;
import tim.lib.dialog.TestDialog;
import tim.model.Client;
import tim.model.Element;
import tim.view.appointmentdialog.AppointmentDialog;

public class Application extends JFrame implements Observer{
	
	JButton btnDialog;
	AppointmentDialog eventDialog;
	Menu menu;
	
	//test
	TestDialog tstDialog;
	JButton btnTstDialog;
	
	public Application() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "Application()");
		}

		setTitle("TIM - Time Is Money");
		setPreferredSize(new Dimension(600, 600));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		menu = new Menu(this);
		setJMenuBar(menu);
		
		btnDialog = new JButton("Dialogue");
		btnTstDialog = new JButton("Dialogue de test");
		Container container = getContentPane();

		btnDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog();
			}
			
		});
		
		btnTstDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showTstDialog();
			}
			
		});
		
		container.setLayout(new FlowLayout());
		
		container.add(btnDialog);
		container.add(btnTstDialog);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void showDialog() {

		eventDialog = new AppointmentDialog(Application.this);
		eventDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		eventDialog.setModal(true);
		eventDialog.setResizable(false);
		eventDialog.pack();
		eventDialog.setLocationRelativeTo(Application.this);
		eventDialog.setVisible(true);
	}
	
	public void showTstDialog() {
		Form form = new Form();
		

		JComboBox cbClient = new JComboBox();
		
		cbClient.addItem("test1");
		cbClient.addItem("test2");
		
		
		FormComponent cClient = new FormComponent(cbClient);
		FormEntry eClient = new FormEntry(new JLabel("Client"));
		eClient.addComponent(cClient);
		form.addEntry(eClient);
		
		FormComponent cDate = new FormComponent(new JTextField(10));
		FormEntry eDate = new FormEntry(new JLabel("Date"));
		eDate.addComponent(cDate);
		form.addEntry(eDate);
		
		FormComponent cTest = new FormComponent(new JTextField(10));
		FormEntry eTest = new FormEntry(new JLabel ("Test"));
		eTest.addComponent(cTest);
		form.addEntry(eTest);
		
		
		tstDialog = new TestDialog(null, Application.this, form, null);
		tstDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		tstDialog.setModal(true);
		tstDialog.setResizable(false);
		tstDialog.pack();
		tstDialog.setLocationRelativeTo(Application.this);
		tstDialog.setVisible(true);
	}
}
