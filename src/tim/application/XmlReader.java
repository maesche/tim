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

import tim.application.utils.ErrorHandler;

import java.io.File;

public class XmlReader {

	public void readConfig(String xmlFilePath) {
		File fXmlFile = null;
		DocumentBuilderFactory dbFactory = null;

		DocumentBuilder dBuilder = null;
		Document doc = null;

		try {

			fXmlFile = new File(xmlFilePath);

			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Node nNode;

			NodeList nList = doc.getElementsByTagName("system");

			if (nList.getLength() > 0) {
				nNode = nList.item(0);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					Config.DATE_FORMAT_SHORT = getTagValue("date-format", eElement);
					Config.DB_URL = getTagValue("db-url", eElement);
				}
			}

			/*
			 * nList = doc.getElementsByTagName("calendar");
			 * 
			 * if(nList.getLength() > 0 && expectedPattern != "") { nNode =
			 * nList.item(0);
			 * 
			 * if (nNode.getNodeType() == Node.ELEMENT_NODE) { Element eElement
			 * = (Element) nNode;
			 * 
			 * 
			 * 
			 * /* //---min-date
			 * appConfig.setMinDate(formatter.parse(getTagValue("min-date",
			 * eElement)));
			 * 
			 * //---max-date
			 * appConfig.setMaxDate(formatter.parse(getTagValue("max-date",
			 * eElement)));
			 * 
			 * //---start-time-hour
			 * appConfig.setStartTimeHour(Integer.parseInt(getTagValue
			 * ("start-time-hour", eElement))); //---start-time-minute
			 * appConfig.
			 * setStartTimeMinute(Integer.parseInt(getTagValue("start-time-minute"
			 * , eElement)));
			 * 
			 * //---end-time-hour
			 * appConfig.setEndTimeHour(Integer.parseInt(getTagValue
			 * ("end-time-hour", eElement))); //---end-time-minute
			 * appConfig.setEndTimeMinute
			 * (Integer.parseInt(getTagValue("end-time-minute", eElement)));
			 * 
			 * //---Interval
			 * appConfig.setInterval(Integer.parseInt(getTagValue("interval",
			 * eElement)));
			 */
			// }
			// }
		} catch (Exception ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "readConfig");
		}
	}
	private String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

	
}