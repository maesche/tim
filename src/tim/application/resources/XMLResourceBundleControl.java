//__________________________________________________________________________________
//
//	Project: 		TIM (Time Is Money)
//	class:			XMLResourceBundleControl + XMLResourceBundle
//	Authors: 		Stefan Meier ; Mathieu Noverraz ; Alain Bellatalla
//	School team: 	IGL3
//	Creation Date: 	17.06.2010
//	Last update:
//	References:		http://download.oracle.com/javase/6/docs/api/java/util/ResourceBundle.Control.html
//	Comments:		These classes are used to translate the label's component
//					in different languages (fr, en, jp)
//__________________________________________________________________________________
package tim.application.resources;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

//__________________________________________________________________________________
//
//		class: XMLResourceBundleControl
//__________________________________________________________________________________
public class XMLResourceBundleControl extends ResourceBundle.Control 
{
	private static String XML = "xml";
	
	//______________________________________________________________________________
	//
	//		Method (overrided): getFormats ; return: String list
	//______________________________________________________________________________
	public List<String> getFormats(String baseName) 
	{
		//System.out.println("baseName: " + baseName);
		//System.out.println("XML: " + XML);
		
		return Collections.singletonList(XML);
	}

	//______________________________________________________________________________
	//
	//	Method (overrided): newBundle ; return: ResourceBundle
	//	Method of the ResourceBundle.Control class
	//
	//	The advantage of overriding the newBundle() method is that it allows you 
	//	to customize the default implementation of the Bundle instantiation to suit 
	//	the specific needs. In this case, we want to plug in our XMLResourceBundle class, 
	//	passing it a BufferedInputStream.
	//______________________________________________________________________________
	public ResourceBundle newBundle(String baseName, 
									Locale locale, 
									String format,
									ClassLoader loader, 
									boolean reload) throws 
													IllegalAccessException, 
													InstantiationException,
													IOException 
	{

		if ((baseName == null) || (locale == null) || (format == null) || (loader == null)) 
		{
			throw new NullPointerException();
		}
    
		ResourceBundle bundle = null;
    
		if (!format.equals(XML)) 
		{
			return null;
		}

		String bundleName = toBundleName(baseName, locale);
		String resourceName = toResourceName(bundleName, format);
		URL url = loader.getResource(resourceName);
    
		if (url == null) 
		{
			return null;
		}
    
		URLConnection connection = url.openConnection();
    
		if (connection == null) 
		{
			return null;
		}
    
		if (reload) 
		{
			connection.setUseCaches(false);
		}
    
		InputStream stream = connection.getInputStream();
    
		if (stream == null) 
		{
			return null;
		}
    
		BufferedInputStream bis = new BufferedInputStream(stream);
		bundle = new XMLResourceBundle(bis);
    
		bis.close();

		return bundle;
	}

	//______________________________________________________________________________
	//
	//	main: only used for test.
	//	Parameters: file name ; XMLResourceBundleControl
	//	File name without extension. It is on the root (src) 
	//	
	//______________________________________________________________________________
	public static void main(String args[]) 
	{
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
		defaultLocale = Locale.UK;
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

//__________________________________________________________________________________
//
//		class: XMLResourceBundle
//__________________________________________________________________________________
class XMLResourceBundle extends ResourceBundle 
{
	private Properties props;
	
	//______________________________________________________________________________
	//
	//		Method: XMLResourceBundle
	//______________________________________________________________________________
	XMLResourceBundle(InputStream stream) throws IOException
	{
		props = new Properties();
		props.loadFromXML(stream);
	}
	
	//______________________________________________________________________________
	//
	//	Method: handleGetObject ; return: Object
	//	Parameter: String key ; The key of the xml file to retrieve the value
	//______________________________________________________________________________
	protected Object handleGetObject(String key) 
	{
		return props.getProperty(key);
	}

	//______________________________________________________________________________
	//
	//	Method: getKeys ; 
	//	return: all keys contained in this ResourceBundle and its parents bundles
	//______________________________________________________________________________
	public Enumeration<String> getKeys() 
	{
		Set<String> handleKeys = props.stringPropertyNames();
		
		return Collections.enumeration(handleKeys);
	}
}