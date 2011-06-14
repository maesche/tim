package tim.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	
	private Application application;
	
	private JMenu file, edit, help, language;
	private JMenuItem quit, english, french, german, japanese;

	public Menu(Application app) {
		this.application = app;
		file = new JMenu("File");
		quit = new JMenuItem("Quit");

		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		file.add(quit);
		add(file);
		
		edit = new JMenu("Edit");
		
		language = new JMenu("Language");
		
		english = new JMenuItem("English");
		french = new JMenuItem("French");
		german = new JMenuItem("German");
		japanese = new JMenuItem("Japanese");
		edit.add(language);
		language.add(english);
		language.add(french);
		language.add(german);
		language.add(japanese);
		add(edit);
		

		help = new JMenu("?");
		add(help);
	}
}
