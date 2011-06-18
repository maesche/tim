package tim.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.ResourceNotFoundException;

public class Menu extends JMenuBar implements AbstractView {
	
	private Application application;
	
	private JMenu file, edit, help, language;
	private JMenuItem quit, english, french, german, japanese;

	public Menu(Application app) {
		this.application = app;
		try {
			GlobalRegistry.mvcLinker.addObserverToSystemResource("LanguageLinker", this);
		} catch (ResourceNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
		
		english = new JMenuItem(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageEnglish"));
		
		english.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("en");
				update();
			}
			
		});
		
		french = new JMenuItem(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageFrench"));
		
		french.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("fr");
				//update();
			}
			
		});
		
		german = new JMenuItem(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageGerman"));
		
		german.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("de");
				//update();
			}
			
		});
		
		japanese = new JMenuItem(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageJapanese"));
		
		japanese.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("ja");
				//update();
			}
			
		});
		
		edit.add(language);
		language.add(english);

		
		language.add(french);
		language.add(german);
		language.add(japanese);
		add(edit);
		

		help = new JMenu("?");
		add(help);
	}
	
	public void update() {
		file.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuFile"));
		quit.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuQuit"));
		edit.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuEdit"));
		language.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguage"));
		english.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageEnglish"));
		french.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageFrench"));
		german.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageGerman"));
		japanese.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuLanguageJapanese"));
		
		
		repaint();

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		update();
	}
	

}
