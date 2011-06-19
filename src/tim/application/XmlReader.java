package tim.application;

//__________________________________________________________________________________
//
//	Project: 		TIM (Time Is Money)
//	class:			ReadXmlFile
//	Authors: 		Stefan Meier ; Mathieu Noverraz ; Alain Bellatalla
//	School team: 	IGL3
//	Creation Date: 	02.06.2010
//	Last update:
//	Comments:		This class is used to read the application config file (xml)
//__________________________________________________________________________________

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.CurrentClassGetter;
import tim.application.utils.ErrorHandler;

import java.io.File;

public class XmlReader {
	

	
	public void readConfig(String xmlFilePath) throws PersistanceException {
		File fXmlFile = null;
		DocumentBuilderFactory dbFactory = null;

		DocumentBuilder dBuilder = null;
		Document doc = null;
		Node nNode;

		try {

			fXmlFile = new File(xmlFilePath);

			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();


			NodeList nList = doc.getElementsByTagName("system");

			if (nList.getLength() > 0) {
				nNode = nList.item(0);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					Config.DATE_FORMAT_SHORT = getTagValue("date-format", eElement);
					Config.TIME_FORMAT = getTagValue("time-format", eElement);
					Config.DB_URL = getTagValue("db-url", eElement);
					Config.DB_DRIVER = getTagValue("db-driver", eElement);
					Config.DB_USER = getTagValue("db-user", eElement);
					Config.DB_PWD = getTagValue("db-pwd", eElement);
					Config.DEFAULT_LANG = getTagValue("default-lang", eElement);
				}
			}
			
			nList = doc.getElementsByTagName("calendar");
			if (nList.getLength() > 0) {
				nNode = nList.item(0);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					Config.CALENDAR_DAY_START = Integer.parseInt(getTagValue("day-start", eElement));
					Config.CALENDAR_DAY_END = Integer.parseInt(getTagValue("day-end", eElement));
					Config.CALENDAR_DAY_INTERVAL = Integer.parseInt(getTagValue("day-interval", eElement));
				}
			}
		} catch (Exception ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "readConfig"));
		}
	}
	private String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

	
}