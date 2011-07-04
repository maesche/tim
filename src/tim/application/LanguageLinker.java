package tim.application;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class sets and gets language information.
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class LanguageLinker extends CustomObservable {
	
	/**
	 * At system start, self registration to global register
	 */
	public LanguageLinker() {
		GlobalRegistry.mvcLinker.registerSystemObservable(this);
	}
	
	public void setLanguageDefault() {
		setLanguage(Config.DEFAULT_LANG);
	}

	/**
	 * At a language change, views are kept informed
	 */
	public void setLanguage(String lang) {
		Config.RESSOURCE_BUNDLE = ResourceBundle.getBundle("lang", new Locale(lang), 
				 new XMLResourceBundleControl());
		Config.DEFAULT_LANG = lang;
		
			this.setChanged();
			this.notifyObservers();
	}
}
