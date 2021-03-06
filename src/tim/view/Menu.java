package tim.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.ResourceNotFoundException;

/**
 * This class holds the applications menu
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class Menu extends JMenuBar implements AbstractView {
	private JMenu file, tools, help, language, manage;
	private JMenuItem quit, english, french, german, japanese, clients;
	private Application application;
	private JMenuItem about;

	public Menu(Application application) {
		this.application = application;
		/**
		 * Register to LanguageLinker as labels may change, following
		 * the current language
		 */
		try {
			GlobalRegistry.mvcLinker.addObserverToSystemResource(
					"LanguageLinker", this);
		} catch (ResourceNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		file = new JMenu();
		quit = new JMenuItem();

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		file.add(quit);
		add(file);

		tools = new JMenu();

		manage = new JMenu();
		clients = new JMenuItem();

		clients.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				showClientDialog();
			}

		});

		language = new JMenu();

		english = new JMenuItem();

		english.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("en");
			}

		});

		french = new JMenuItem();

		french.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("fr");
			}

		});

		german = new JMenuItem();

		german.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("de");
			}

		});

		japanese = new JMenuItem();

		japanese.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				GlobalRegistry.languageLinker.setLanguage("ja");
			}

		});

		manage.add(clients);
		tools.add(manage);
		tools.add(language);

		language.add(english);

		language.add(french);
		language.add(german);
		language.add(japanese);
		add(tools);

		help = new JMenu("?");
		about = new JMenuItem();
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				about();
			}

		});
		help.add(about);
		add(help);
		update();
	}

	/**
	 * On update, replaces all labels with the current language text
	 */
	public void update() {
		file.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuFile"));
		quit.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuQuit"));
		tools.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuTools"));
		manage.setText(Config.RESSOURCE_BUNDLE
				.getString("applicationMenuManage"));
		clients.setText(Config.RESSOURCE_BUNDLE
				.getString("applicationMenuClients"));
		language.setText(Config.RESSOURCE_BUNDLE
				.getString("applicationMenuLanguage"));
		english.setText(Config.RESSOURCE_BUNDLE
				.getString("applicationMenuLanguageEnglish"));
		french.setText(Config.RESSOURCE_BUNDLE
				.getString("applicationMenuLanguageFrench"));
		german.setText(Config.RESSOURCE_BUNDLE
				.getString("applicationMenuLanguageGerman"));
		japanese.setText(Config.RESSOURCE_BUNDLE
				.getString("applicationMenuLanguageJapanese"));
		about.setText(Config.RESSOURCE_BUNDLE.getString("applicationMenuAbout"));
		repaint();
	}

	private void about() {
		JOptionPane.showMessageDialog(
				application,
				"<html>"
						+ Config.RESSOURCE_BUNDLE
								.getString("dialogAboutCompany")
						+ ": SAM<br />"
						+ Config.RESSOURCE_BUNDLE
								.getString("dialogAboutAuthor")
						+ ":<ul style='list-style-type: none'>"
						+ "<li>Stefan Meier ;</li>"
						+ "<li>Mathieu Noverraz ;</li>"
						+ "<li>Alain Bellatalla.</li>"
						+ "</ul>" 
						+ "<br />"
						+"</html>",
				Config.RESSOURCE_BUNDLE.getString("applicationMenuAbout")
						, JOptionPane.PLAIN_MESSAGE);
	}

	public void close() {
		application.close();
	}

	@Override
	public void update(Observable observable, Object arg) {
		update();
	}

	public void showClientDialog() {
		application.showClientDialog();
	}

}
