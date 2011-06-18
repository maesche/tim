package tim.application;

import java.util.Locale;
import java.util.ResourceBundle;


public class LanguageLinker extends CustomObservable {
	
	public LanguageLinker() {
		GlobalRegistry.mvcLinker.registerSystemObservable(this);
	}
	
	public void setLanguageDefault() {
		setLanguage(Config.DEFAULT_LANG);
	}

	public void setLanguage(String lang) {
		Config.RESSOURCE_BUNDLE = ResourceBundle.getBundle("lang", new Locale(lang), 
				 new XMLResourceBundleControl());

			this.setChanged();
			this.notifyObservers();
	}
	

}
