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
import java.io.File;

import java.text.SimpleDateFormat;

//__________________________________________________________________________________
//
//		class: ReadXmlFile
//__________________________________________________________________________________
public class ReadXmlFile 
{
	//______________________________________________________________________________
	//
	//		main
	//______________________________________________________________________________
	public static void main(String argv[]) 
	{
		try 
		{
			String xmlFilePath = "d:\\_My Documents\\_HEIG-VD\\IL3\\_ProjSem\\tim\\config\\applicationSettings.xml";
			
			XmlApplicationConfig appConfig = new XmlApplicationConfig();
			
			//---Read the xml file
			appConfig = readConfig(xmlFilePath);
			
			if (appConfig != null)
			{
			    //---Just for test
			    System.out.println("Date format: "  + appConfig.getDateFormat());
			    System.out.println("Language: "  + appConfig.getDefaultLanguage());
			    System.out.println("Min date: "  + appConfig.getMinDate());
			    System.out.println("Max date: "  + appConfig.getMaxDate());
			    System.out.println("Start time: "  + appConfig.getStartTimeHour() + ":" + appConfig.getStartTimeMinute());
			    System.out.println("End time: "  + appConfig.getEndTimeHour() + ":" + appConfig.getEndTimeMinute());
			    System.out.println("Interval: "  + appConfig.getInterval());
			  
			    SimpleDateFormat sdf = new SimpleDateFormat("dd");		    
			    System.out.println("Min date day: "  + sdf.format(appConfig.getMinDate()));
			}
			else
			{
				System.out.println("No values was returned from xml file");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	//______________________________________________________________________________
	//
	//		Methode: getTagValue ; return: String
	//______________________________________________________________________________
	private static String getTagValue(String sTag, Element eElement)
	{
		NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0); 
 
		return nValue.getNodeValue();    
	}
	
	//______________________________________________________________________________
	//
	//		Methode: readConfig ; return: XmlApplicationConfig
	//______________________________________________________________________________
	private static XmlApplicationConfig readConfig(String xmlFilePath)
	{
		XmlApplicationConfig appConfig = new XmlApplicationConfig();
		
		try 
		{
			//XmlApplicationConfig appConfig = new XmlApplicationConfig();
			
		    //File fXmlFile = new File("c:\\file.xml");
		    File fXmlFile = new File(xmlFilePath);
		    
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(fXmlFile);
		    doc.getDocumentElement().normalize();
		    Node nNode;
		    String expectedPattern = "";
		    
		    //System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		    
		    //---System
		    NodeList nList = doc.getElementsByTagName("system");
		    
		    //for (int temp = 0; temp < nList.getLength(); temp++) 
		    //{
		    if (nList.getLength() > 0)
		    {
		       nNode = nList.item(0);
		       
		       if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		       {
		          Element eElement = (Element) nNode;
		          
		          //---Get the Date pattern
		          expectedPattern = appConfig.getDateFormat();
		          
		          appConfig.setDateFormat(getTagValue("date-format", eElement));
		          appConfig.setDefaultLanguage(getTagValue("default-language", eElement));
		       }
		    }
		    
		    //---calendar
		    nList = doc.getElementsByTagName("calendar");
		    
		    //for (int temp = 0; temp < nList.getLength(); temp++) 
		    //{
		    if(nList.getLength() > 0 && expectedPattern != "")
		    {
		       nNode = nList.item(0);
		       
		       if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		       {
		          Element eElement = (Element) nNode;
		          
		          //---Date format
		          SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		          
		          //---min-date
		          appConfig.setMinDate(formatter.parse(getTagValue("min-date", eElement)));
		          
		          //---max-date
		          appConfig.setMaxDate(formatter.parse(getTagValue("max-date", eElement)));
		          
		          //---start-time-hour
		          appConfig.setStartTimeHour(Integer.parseInt(getTagValue("start-time-hour", eElement)));
		          //---start-time-minute
		          appConfig.setStartTimeMinute(Integer.parseInt(getTagValue("start-time-minute", eElement)));
		          
		          //---end-time-hour
		          appConfig.setEndTimeHour(Integer.parseInt(getTagValue("end-time-hour", eElement)));
		          //---end-time-minute
		          appConfig.setEndTimeMinute(Integer.parseInt(getTagValue("end-time-minute", eElement)));
		          
		          //---Interval
		          appConfig.setInterval(Integer.parseInt(getTagValue("interval", eElement)));
		       }
		    }  
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return appConfig;
	}
}