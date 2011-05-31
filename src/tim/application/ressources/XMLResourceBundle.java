package tim.application.ressources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public abstract class XMLResourceBundle extends ResourceBundle {

	private final Properties xmlProperties = new Properties();

	protected XMLResourceBundle() throws IOException {
		String resName = getClass().getName().replace('.', '/') + ".xml";
		InputStream stream = getClass().getClassLoader().getResourceAsStream(
				resName);
		try {
			this.xmlProperties.loadFromXML(stream);
		} finally {
			stream.close();
		}
	}

	public Object handleGetObject(String key) {
		return this.xmlProperties.get(key);
	}

	public Enumeration getKeys() {
		return this.xmlProperties.keys();
	}

}
