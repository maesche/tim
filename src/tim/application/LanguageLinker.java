package tim.application;

import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

import tim.application.resources.XMLResourceBundleControl;

public class LanguageLinker extends Observable {
	
	public LanguageLinker() {
		GlobalRegistry.mvcLinker.registerSystemObservable(this);
	}
	
	public void setLanguageDefault() {
		Config.RESSOURCE_BUNDLE = ResourceBundle.getBundle("lang", new Locale(Config.DEFAULT_LANG), 
				 new XMLResourceBundleControl());
	}

	public void setLanguage(String lang) {
		Config.RESSOURCE_BUNDLE = ResourceBundle.getBundle("lang", new Locale(lang), 
				 new XMLResourceBundleControl());

			this.setChanged();
			this.notifyObservers();
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
