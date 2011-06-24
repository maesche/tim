package tim.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import tim.application.BootLoader;
import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.CurrentClassGetter;
import tim.controller.Controller;
import tim.view.calendar.CalendarContainer;
import tim.view.calendar.DayNavigation;
import tim.view.dialog.client.ClientDialog;

public class Application extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Menu menu;
	CalendarContainer calendarContainer;
	JPanel navBar;
	ClientDialog clientDialog;
	
	public Application() throws ParseException {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			new ExceptionView (ExceptionFormatter.format(ex, new CurrentClassGetter().getClassName(), "constructor"));
		}

		setTitle("TIM - Time Is Money");
		setPreferredSize(new Dimension(600, 600));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					BootLoader.dispose();
				} catch (PersistanceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		menu = new Menu(this);
		setJMenuBar(menu);

		calendarContainer = new CalendarContainer();

		setLayout(new BorderLayout());
		
		
		navBar = new DayNavigation();
	
		add(navBar, BorderLayout.NORTH);
		add(calendarContainer, BorderLayout.CENTER);
	}
	
	public void showClientDialog() {
		clientDialog = new ClientDialog(new Controller());
		clientDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		clientDialog.setModal(true);
		clientDialog.setResizable(false);
		clientDialog.setLocationRelativeTo(Application.this);
		clientDialog.setVisible(true);
	}
}
