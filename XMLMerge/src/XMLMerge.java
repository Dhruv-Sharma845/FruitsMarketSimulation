import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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

public class XMLMerge {

	public static void main(String[] args) throws FileNotFoundException
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db=null;
		try {
			
			db = dbf.newDocumentBuilder();
		} 
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		File f1=new File("C:\\Users\\dhruv\\eclipse-workspace\\XMLMerge\\src\\License1.txt");
		File f2=new File("C:\\Users\\dhruv\\eclipse-workspace\\XMLMerge\\src\\License2.txt");
		
		Document doc1=null;
		try {
			doc1 = db.parse(f1);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		doc1.getDocumentElement().normalize();
		
		Document doc2=null;
		try {
			doc2 = db.parse(f2);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		doc2.getDocumentElement().normalize();
		
		
		NodeList csr_prodList1 = doc1.getElementsByTagName("CSR_Producer");
		NodeList csr_prodList2 = doc2.getElementsByTagName("CSR_Producer");
		
		
		for(int i=0;i<csr_prodList1.getLength();i++)
		{
			Node csrNode1=csr_prodList1.item(i);
			//System.out.println(nNode.getNodeName());
			for(int j=0;j<csr_prodList2.getLength();j++)
			{
				Node csrNode2=csr_prodList2.item(j);
				
				Element csrE1 = (Element)csrNode1;
				Element csrE2 = (Element)csrNode2;
				
				//System.out.println(e1.getAttribute("NIPR_Number"));
				//System.out.println(e2.getAttribute("NIPR_Number"));
				
				if(csrE1.getAttribute("NIPR_Number").equals(csrE2.getAttribute("NIPR_Number")))
				{
					NodeList LicenseNodeList1 = csrE1.getElementsByTagName("License");
					NodeList LicenseNodeList2 = csrE2.getElementsByTagName("License");
					
					for(int k=0;k<LicenseNodeList1.getLength();k++)
					{
						Node LicenseNode1=LicenseNodeList1.item(k);
						//System.out.println(nNode.getNodeName());
						for(int l=0;l<LicenseNodeList2.getLength();l++)
						{
							Node LicenseNode2=LicenseNodeList2.item(l);
							
					
							Element LicenseE1=(Element)LicenseNode1;
							Element LicenseE2=(Element)LicenseNode2;
							
							if(LicenseE1.getAttribute("License_Status").equals("N"))
							{
								/*FileOutputStream fos=new FileOutputStream("C:\\Users\\dhruv\\eclipse-workspace\\XMLMerge\\src\\InvalidLic.xml");
								PrintWriter pw=new PrintWriter(fos,true);
								pw.print(LicenseE1.getAttribute("License_Number")+ "  ");
								pw.print(LicenseE1.getAttribute("License_Class_Code")+ "  ");
								pw.print(LicenseE1.getAttribute("License_Expiration_Date")+ "  ");
								pw.println("\n");
								
								pw.close();*/
								
								TransformerFactory tFactory = TransformerFactory.newInstance();
						        Transformer transformer=null;
								try {
									transformer = tFactory.newTransformer();
								} catch (TransformerConfigurationException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
						        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

						        DOMSource source = new DOMSource(LicenseNode1);
						        StreamResult result = new StreamResult(new StringWriter());
						        try {
									transformer.transform(source, result);
								} catch (TransformerException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

						        Writer output=null;
								try {
									output = new BufferedWriter(new FileWriter("C:\\Users\\dhruv\\eclipse-workspace\\XMLMerge\\src\\InvalidLic.xml"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        String xmlOutput = result.getWriter().toString();
						        try {
									output.write(xmlOutput);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        try {
									output.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if(LicenseE2.getAttribute("License_Status").equals("N"))
							{
								/*FileOutputStream fos=new FileOutputStream("C:\\Users\\dhruv\\eclipse-workspace\\XMLMerge\\src\\InvalidLic.xml");
								PrintWriter pw=new PrintWriter(fos,true);
								pw.print(LicenseE1.getAttribute("License_Number")+ "  ");
								pw.print(LicenseE1.getAttribute("License_Class_Code")+ "  ");
								pw.print(LicenseE1.getAttribute("License_Expiration_Date")+ "  ");
								pw.println("\n");
								
								pw.close();*/
								
								
								TransformerFactory tFactory = TransformerFactory.newInstance();
						        Transformer transformer=null;
								try {
									transformer = tFactory.newTransformer();
								} catch (TransformerConfigurationException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
						        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

						        DOMSource source = new DOMSource(LicenseNode2);
						        StreamResult result = new StreamResult(new StringWriter());
						        try {
									transformer.transform(source, result);
								} catch (TransformerException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

						        Writer output=null;
								try {
									output = new BufferedWriter(new FileWriter("C:\\Users\\dhruv\\eclipse-workspace\\XMLMerge\\src\\InvalidLic.xml"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        String xmlOutput = result.getWriter().toString();
						        try {
									output.write(xmlOutput);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        try {
									output.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if(LicenseE1.getAttribute("State_Code").equals(LicenseE2.getAttribute("State_Code")))
							{
								if(LicenseE1.getAttribute("License_Number").equals(LicenseE2.getAttribute("License_Number")))
								{
									if(LicenseE1.getAttribute("Date_Status_Effective").equals(LicenseE2.getAttribute("Date_Status_Effective")))
									{
										NodeList LOAList = LicenseE2.getElementsByTagName("LOA");
										for(int m=0;m<LOAList.getLength();m++)
										{
											LicenseNode1.appendChild(doc1.importNode(LOAList.item(m),true));
										}
										//LicenseNode1.appendChild(doc1.importNode(getChildrenByNodeName(LicenseNode2,"LOA"), arg1))
									}
								}
							}
						}
					}
				}
			}
		}
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer=null;
		try {
			transformer = tFactory.newTransformer();
		} catch (TransformerConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc1);
        StreamResult result = new StreamResult(new StringWriter());
        try {
			transformer.transform(source, result);
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        Writer output=null;
		try {
			output = new BufferedWriter(new FileWriter("C:\\Users\\dhruv\\eclipse-workspace\\XMLMerge\\src\\Result.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String xmlOutput = result.getWriter().toString();
        try {
			output.write(xmlOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
