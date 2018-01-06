import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXml {
	
	public static void main(String[] args)
	{
		File f=new File("C:\\Users\\dhruv\\eclipse-workspace\\XMLTest\\src\\temp.txt");
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=null;
		try {
			
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc=null;
		try {
			doc = db.parse(f);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doc.getDocumentElement().normalize();
		System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("student");
		
		for(int i=0;i<nList.getLength();i++)
		{
			Node nNode=nList.item(i);
			System.out.println(nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element e = (Element)nNode;
				System.out.println(e.getAttribute("rollno"));
				
				System.out.println(e.getElementsByTagName("firstname").item(0).getTextContent());
			}
			
		}
	}
}
