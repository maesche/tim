package tim.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tim.application.BootLoader;

public class Menu extends JMenuBar {
	
	private Application application;
	
	private JMenu file, edit, help;
	private JMenuItem quit;

	public Menu(Application app) {
		this.application = app;
		file = new JMenu(BootLoader.APPLICATION_MENU_FILE);
		edit = new JMenu("Edit");
		help = new JMenu("?");
		add(file);
		add(edit);
		add(help);
		
		quit = new JMenuItem("Quit");
	
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		file.add(quit);

		
	}
}
