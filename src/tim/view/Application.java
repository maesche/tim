package tim.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import tim.application.ErrorHandler;

public class Application extends JFrame {
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

		Container container = getContentPane();

		container.add(new JButton("test"));
	}
}
