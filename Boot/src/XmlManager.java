import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlManager implements IManager {

	private static String _filepath = "file.xml";
	
	private Document _doc;
	
	private List<Hyperlink> _hyperlinkList;
	public List<Hyperlink> GetHyperlinkList()
	{
		return _hyperlinkList; 
	}
	
	private static IManager _instance;
	public static IManager GetInstance()
	{
		if(_instance == null)
		{
			System.out.println("instance generated");	
			_instance = new XmlManager(_filepath);
		}

		return _instance;		
	}
	
	private XmlManager(String filepath)
	{
		_filepath = filepath;
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			_doc = docBuilder.parse(_filepath);	
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GenerateHyperlinkList();
	}
	
	public void Edit(Hyperlink from, Hyperlink to)
	{
		RemoveByName(from.GetName());
		Add(to);
	}
	
	public List<Hyperlink> Search(String keywords) 
	{
		List<Hyperlink> searchResults = new ArrayList<Hyperlink>(_hyperlinkList);
		
		String[] keywordsList = keywords.split(" ");
		
		for(String k : keywordsList)
		{
			System.out.print(k + " : ");
			List<Hyperlink> removed = new ArrayList<Hyperlink>();
			for(Hyperlink h : searchResults)
			{
				if(!(h.GetSearchTags().contains(" " + k + " "))) removed.add(h);
				System.out.print(h.GetName() + " ");				
				
			}
			System.out.println();
			if(!removed.isEmpty())
			{
				for(Hyperlink r : removed)
					searchResults.remove(r);
			}
		}
		
		return searchResults;		
	}
	
	public void Add(Hyperlink hyperlink)
	{
		RemoveByName(hyperlink.GetName());
		AddNew(hyperlink);
	}
	
	private void RemoveByName(String name)
	{
		//Remove from XML
		Node rootNode = _doc.getElementsByTagName("Hyperlinks").item(0);
		NodeList hyperlinkXMLs = _doc.getElementsByTagName("Hyperlink");
		
		for(int i = 0; i < hyperlinkXMLs.getLength(); i++)
		{				
			Node hXml = hyperlinkXMLs.item(i);
			
			NodeList hyperlinkChild = hXml.getChildNodes();
			
			boolean rightName = false;
			for (int j = 0; j < hyperlinkChild.getLength(); j++)
			{
				Node elem = hyperlinkChild.item(j);					
				if("Name".equals(elem.getNodeName()) && name.equals(elem.getTextContent())) rightName = true;
			}
			
			if(rightName)
			{
				rootNode.removeChild(hXml);
			}
		}
		
		//Remove from List
		Hyperlink removed = null;
		for(Hyperlink h : _hyperlinkList)
		{
			if(name.equals(h.GetName())) removed = h;
		}
		if(removed != null)
		{
			_hyperlinkList.remove(removed);
		}
	}
	
	//<Hyperlink>
	//	<Name>name</name>	
	//	<Url>www.name.com</Url>
	//	<Metatag>
	//		<Name>metatag</Name>
	//		<Description>this is a metatag</Description>
	//	</Metatag>
	//	<Comment>This is a cool comment </Comment>
	//</Hyperlink>
	private void AddNew(Hyperlink hyperlink)
	{
		//Add to XML
		Node mainTag = _doc.getElementsByTagName("Hyperlinks").item(0);
		Element hyperlinkXML = _doc.createElement("Hyperlink");
		
		//Add name
		Element name = _doc.createElement("Name");
		name.appendChild(_doc.createTextNode(hyperlink.GetName()));
		hyperlinkXML.appendChild(name);
		
		//Add Url
		Element url = _doc.createElement("Url");
		url.appendChild(_doc.createTextNode(hyperlink.GetUrl()));
		hyperlinkXML.appendChild(url);
		
		//Add Metatags
		for(Metatag m : hyperlink.GetMetatags())
		{
			Element metatag = _doc.createElement("Metatag");
			
			//Add Metatag Name
			Element tagName = _doc.createElement("Name");
			tagName.appendChild(_doc.createTextNode(m.GetName()));
			metatag.appendChild(tagName);
			
			//Add Metatag Description
			Element tagDescription = _doc.createElement("Description");
			tagDescription.appendChild(_doc.createTextNode(m.GetDescription()));
			metatag.appendChild(tagDescription);
			
			hyperlinkXML.appendChild(metatag);
		}
		
		//Add comments
		Element comment = _doc.createElement("Comment");
		comment.appendChild(_doc.createTextNode(hyperlink.GetComments()));
		
		hyperlinkXML.appendChild(comment);	

		mainTag.appendChild(hyperlinkXML);
		
		//Add to list
		_hyperlinkList.add(hyperlink);
	}
	

	private void GenerateHyperlinkList() 
	{				
		List<Hyperlink> hyperlinkList = new ArrayList<Hyperlink>();
		NodeList hyperlinkXMLs = _doc.getElementsByTagName("Hyperlink");
		
		for(int i = 0; i < hyperlinkXMLs.getLength(); i++)
		{				
			Node hXml = hyperlinkXMLs.item(i);
			
			NodeList hyperlinkChild = hXml.getChildNodes();
			
			String name = "";
			String url = "";
			List<Metatag> metatags = new ArrayList<Metatag>();
			String comments = "";
			
			for (int j = 0; j < hyperlinkChild.getLength(); j++)
			{
				Node elem = hyperlinkChild.item(j);				
				
				if("Name".equals(elem.getNodeName()))  name = elem.getTextContent();
				
				if("Url".equals(elem.getNodeName())) url = elem.getTextContent();
				
				if("Metatag".equals(elem.getNodeName()))
				{
					NodeList metatagChild = elem.getChildNodes();
					
					String metatagName = "";
					String metatagDescription = "";
					
					for (int k = 0; k < metatagChild.getLength(); k++)
					{
						Node metatagElem = metatagChild.item(k);
						
						if("Name".equals(metatagElem.getNodeName()))  metatagName = metatagElem.getTextContent();
						if("Description".equals(metatagElem.getNodeName()))  metatagDescription = metatagElem.getTextContent();
					}
					
					metatags.add(new Metatag(metatagName, metatagDescription));
				}
				
				if("Comment".equals(elem.getNodeName()))  comments = elem.getTextContent();
			}
			
			hyperlinkList.add(new Hyperlink(name, url, metatags, comments));
		}		
		
		_hyperlinkList = hyperlinkList;
	}
	
	public void Save()
	{			
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(_doc);
			StreamResult result = new StreamResult(new File(_filepath));
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
