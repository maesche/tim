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
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import tim.application.Config;

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
		//---Check if every parameters are set
		if ((baseName == null) || (locale == null) || 
			  (format == null) || (loader == null)) 
		{
			throw new NullPointerException();
		}
    
		ResourceBundle bundle = null;
		
		//---Check if the format is a xml file
		if (!format.equals(XML)) 
		{
			return null;
		}

		String bundleName = toBundleName("tim.res.lang.lang", locale);
		System.out.println(bundleName);
		String resourceName = toResourceName(bundleName, format);
		URL url = loader.getResource(resourceName);
		
		//---Check the path file
		if (url == null) 
		{
			return null;
		}
    
		URLConnection connection = url.openConnection();
		
		//---Check the connection
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
}


