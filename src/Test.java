import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import tim.application.Config;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = Config.CONFIG_PATH + "xml/application.xml";
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance("tim.application.Config.class");
		} catch (JAXBException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Marshaller marshaller = null;
		try {
			marshaller = context.createMarshaller();
		} catch (JAXBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		} catch (PropertyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Config config = null;
		try {
			marshaller.marshal((Config) config, new FileWriter(fileName));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
