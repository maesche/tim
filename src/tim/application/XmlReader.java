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

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import tim.application.utils.ErrorHandler;

import java.io.File;
import java.util.HashMap;

public class XmlReader {
	
	private void afficher(Node n) {
	    if (n.getNodeType() == org.w3c.dom.Node.TEXT_NODE) {
	    	if (n.getTextContent().isEmpty())
		        System.out.println(n.getNodeName() + " " + n.getNodeValue() + " " + n.getNodeValue().length());
	        }
	    else if (n instanceof Element) {
	        NodeList fils = n.getChildNodes();
	        for(int i=0; (i < fils.getLength()); i++) {
	            afficher(fils.item(i));
	            }
	        }
	    else if (n instanceof Document) {
	        NodeList fils = n.getChildNodes();
	        for(int i=0; (i < fils.getLength()); i++) {
	            afficher(fils.item(i));
	            }
	        }
	    }
	
	public HashMap<String, Object> read(String xmlFilePath, HashMap<String, Object> values) {
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

			NodeList nList = doc.getElementsByTagName("configuration");
			this.afficher(doc);
			/*for(int i=0; i<nList.getLength(); i++){
				System.out.println(nList.getLength());
				NodeList n = (NodeList)nList.item(i);
				//e.getChildNodes();
				System.out.println(n.item(0).getNodeName());
			}*/
			/*if (values != null) {
				for (String configName: values.keySet()) {
					NodeList nList = doc.getElementsByTagName(configName);
					if (values.get(configName) instanceof HashMap && nList.getLength() > 0) {
						nNode = nList.item(0);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							@SuppressWarnings("unchecked")
							HashMap<String, Object> configs = (HashMap<String, Object>) values.get(configName);
							for (String configValue: configs.keySet()) {
								String value = getTagValue(configValue, eElement);
								configs.put(configValue, value);;
							}
						}
					}

				}
			}*/
		} catch (Exception ex) {
			ErrorHandler.getException(ex, this.getClass().getName(), "read");
		}
		return values;
	}

	public void readConfig(String xmlFilePath) {
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