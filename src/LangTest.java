import java.util.Locale;
import java.util.ResourceBundle;

import tim.application.resources.XMLResourceBundleControl;


public class LangTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String baseName = "Strings";
		String baseName = "lang";
		
		//---fr_CH
		Locale defaultLocale = Locale.getDefault();
		System.out.println("default: " + defaultLocale);
		System.out.println("default country: " + defaultLocale.getDisplayCountry());
		System.out.println("default language: " + defaultLocale.getDisplayLanguage());
		 
		//---Find the corresponding xml file properties (getBundle)
		//   How it's work:
		//	    Search the file base on the given name (baseName = lang) in this order:
		//		lang_fr_CH_UNIX
		//		lang_fr_CH
		//		lang_fr
		//		lang
		//	 If not found, then MissingResourceException error occurs
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, 
														 new XMLResourceBundleControl());
    
		System.out.println("System Error: " + bundle.getString("applicationErrorSystem"));
		System.out.println("About: " + bundle.getString("applicationMenuAbout"));
		System.out.println("Edit: " + bundle.getString("applicationMenuEdit"));
		System.out.println("File: " + bundle.getString("applicationMenuFile"));
		System.out.println("Quit: " + bundle.getString("applicationMenuQuit"));
		System.out.println("Language: " + bundle.getString("applicationMenuLanguage"));
		
		System.out.println("Message: " + bundle.getString("dialogMessages"));
		System.out.println("Begin: " + bundle.getString("dialogBegin"));
		System.out.println("Cancel: " + bundle.getString("dialogCancel"));
		System.out.println("Date: " + bundle.getString("dialogDate"));
		System.out.println("Description: " + bundle.getString("dialogDescription"));
		System.out.println("End: " + bundle.getString("dialogEnd"));
		System.out.println("Save: " + bundle.getString("dialogSave"));
		
		//---Set default Locale
		defaultLocale = Locale.JAPANESE;
		Locale.setDefault(defaultLocale);
		
		bundle = ResourceBundle.getBundle(baseName, 
				 new XMLResourceBundleControl());
		
		System.out.println("-------------------------------------------");
		System.out.println("System Error: " + bundle.getString("applicationErrorSystem"));
		System.out.println("About: " + bundle.getString("applicationMenuAbout"));
		System.out.println("Edit: " + bundle.getString("applicationMenuEdit"));
		System.out.println("File: " + bundle.getString("applicationMenuFile"));
		System.out.println("Quit: " + bundle.getString("applicationMenuQuit"));
		System.out.println("Language: " + bundle.getString("applicationMenuLanguage"));
		
		System.out.println("Message: " + bundle.getString("dialogMessages"));
		System.out.println("Begin: " + bundle.getString("dialogBegin"));
		System.out.println("Cancel: " + bundle.getString("dialogCancel"));
		System.out.println("Date: " + bundle.getString("dialogDate"));
		System.out.println("Description: " + bundle.getString("dialogDescription"));
		System.out.println("End: " + bundle.getString("dialogEnd"));
		System.out.println("Save: " + bundle.getString("dialogSave"));

	}

}
