package tim.application;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;

import java.io.File;

/**
 * This class is used to read and update the application config file (xml)
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704 
 */
public class XmlConfigHandler {
	
	/**
	 * Reads the application configuration from a XML file
	 */
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
					Config.CURRENT_DATE = getTagValue("current-date", eElement);
				}
			}
		} catch (Exception ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "readConfig"));
		}
	}

	/**
	 * Gets the desired node value of the XML file
	 * 
	 */
	private String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}
	
	/**
	 * Writes the current configuraiton to the config file
	 * @param xmlFilePath
	 * @throws PersistanceException
	 */
	public void writeConfig(String xmlFilePath) throws PersistanceException {
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFilePath);

	        //---Get the element by tag name directly. Ex.: "default-lang"
			

	        doc.getElementsByTagName("default-lang").item(0).setTextContent(Config.DEFAULT_LANG);
	        doc.getElementsByTagName("current-date").item(0).setTextContent(Config.CURRENT_DATE);
	        
	        
	        //nodeToUpdate.setNodeValue("en"); 	 <== not the good method
	        //nodeToUpdate.setTextContent("en"); <== the good method
	       
	        
		    //---Write the content into xml file
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    
		    DOMSource source = new DOMSource(doc);
		    StreamResult result =  new StreamResult(new File(xmlFilePath));
		    
		    transformer.transform(source, result);
	 
		}
		catch (Exception ex)
	    {
			throw new PersistanceException(ExceptionFormatter.format(ex, 
																	 this.getClass().getName(), 
																	 "writeConfig"));
	    }
	}
	
}