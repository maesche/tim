package tim.application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

//__________________________________________________________________________________
//
//		class: XMLResourceBundle
//__________________________________________________________________________________
public class XMLResourceBundle extends ResourceBundle {

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
	@Override
	protected Object handleGetObject(String key) 
	{
		return props.getProperty(key);
	}

	//______________________________________________________________________________
	//
	//	Method: getKeys ; 
	//	return: all keys contained in this ResourceBundle and its parents bundles
	//______________________________________________________________________________
	@Override
	public Enumeration<String> getKeys() 
	{
		Set<String> handleKeys = props.stringPropertyNames();
		
		return Collections.enumeration(handleKeys);
	}

}
