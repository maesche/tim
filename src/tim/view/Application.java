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
import javax.swing.JFrame;
import javax.swing.UIManager;

import tim.application.utils.ErrorHandler;
import tim.view.appointmentdialog.AppointmentDialog;

public class Application extends JFrame implements Observer{
	
	JButton btnDialog;
	AppointmentDialog eventDialog;
	Menu menu;
	
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
		Container container = getContentPane();

		btnDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog();
			}
			
		});
		container.setLayout(new FlowLayout());
		
		container.add(btnDialog);
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
}
