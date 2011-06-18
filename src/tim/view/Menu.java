package tim.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tim.application.Config;
import tim.application.GlobalRegistry;

public class Menu extends JMenuBar {
	
	private Application application;
	
	private JMenu file, edit, help, language;
	private JMenuItem quit, english, french, german, japanese;

	public Menu(Application app) {
		this.application = app;
		file = new JMenu(Config.RESSOURCE_BUNDLE.getString("applicationMenuFile"));
		quit = new JMenuItem(Config.RESSOURCE_BUNDLE.getString("applicationMenuQuit"));

		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		file.add(quit);
		add(file);
		
		edit = new JMenu(Config.RESSOURCE_BUNDLE.getString("applicationMenuEdit"));
		
		language = new JMenu(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguage"));
		
		english = new JMenuItem("English");
		french = new JMenuItem("French");
		
		french.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Config.DEFAULT_LANG = "fr";
				GlobalRegistry.bootLoader.reload();
			}
			
		});
		
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
