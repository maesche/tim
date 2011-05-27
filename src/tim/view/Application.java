package tim.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import tim.application.ErrorHandler;

public class Application extends JFrame {
	
	JButton btnDialog;
	JDialog eventDialog;
	
	public Application() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "Application()");
		}

		setTitle("Application");
		setPreferredSize(new Dimension(300, 300));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		btnDialog = new JButton("Dialogue");
		Container container = getContentPane();

		btnDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventDialog.setLocationRelativeTo(Application.this);
				eventDialog.setVisible(true);
			}
			
		});
		
		container.add(btnDialog);
	}
}
