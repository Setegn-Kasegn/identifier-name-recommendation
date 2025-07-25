
package domelements;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class xmlfilter {
     public static void main(String[] args) {
          try {
			FileInputStream file = new FileInputStream(new File("E://A.xml"));
	                FileOutputStream out=new FileOutputStream("E://Aoutput.txt");
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder =  builderFactory.newDocumentBuilder();
			
			Document xmlDocument = builder.parse(file);

			XPath xPath =  XPathFactory.newInstance().newXPath();

			System.out.println("*************************");
                        String wrd[];
			String expression="/unit/class/name";
                        String fl="";
                        String fle="";
			System.out.println(expression);
			String classname="";
//           for (int i = 0; i < 10; i++) {
//                //classname = xPath.compile(expression[i]).evaluate(xmlDocument);
//                            System.out.println(xPath.compile(expression[i]).evaluate(xmlDocument));
//           }
                        //System.out.println(expression.length);    			
                        NodeList nodLst = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; i < nodLst.getLength(); i++) {
                          System.out.println(nodLst.item(i).getFirstChild().getNodeValue().replaceAll("(?<=[a-z])([A-Z])", " $1"));  
			    fl=nodLst.item(i).getFirstChild().getNodeValue().replaceAll("(?<=[a-z])([A-Z])", " $1"); 
			fle=fle+fl;
                        
                      PrintStream p=new PrintStream(out);
                       p.println(fle+"/");
                        }
                        System.out.println("*************************");
			expression = "/unit/class/block/decl_stmt/decl/name";
			System.out.println(expression);
                         String gvrbl="";
                        String gvrble="";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
                            System.out.println(nodeList.item(i).getFirstChild().getNodeValue().replaceAll("(?<=[a-z])([A-Z])", " $1"));
			  gvrbl=nodeList.item(i).getFirstChild().getNodeValue().replaceAll("(?<=[a-z])([A-Z])", " $1"); 
			gvrble=gvrble+gvrbl;
                        PrintStream pe=new PrintStream(out);
                       pe.println(gvrble+" "+"/");
                        }
                       
                        
			System.out.println("*************************");
			expression = "/unit/class/block/function/block/decl_stmt/decl/name";
			System.out.println(expression);
			NodeList nodList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; i < nodList.getLength(); i++) {
			    System.out.println(nodList.item(i).getFirstChild().getNodeValue().replaceAll("(?<=[a-z])([A-Z])", " $1")); 
			}

			System.out.println("*************************");
			expression = "/unit/class/block/function/name";
			System.out.println(expression);
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
			    System.out.println(nodeList.item(i).getFirstChild().getNodeValue().replaceAll("(?<=[a-z])([A-Z])", " $1")); 
			}
			Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
			if(null != node) {
				nodeList = node.getChildNodes();
				for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
					Node nod = nodeList.item(i);
					if(nod.getNodeType() == Node.ELEMENT_NODE)
					System.out.println(nodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue()); 
				}
			}
			for (int i = 0; i < nodeList.getLength(); i++) {
			    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
			}
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
			    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
			}
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
			    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
			}
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
			    System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
                            System.out.println("*************************");
                      
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}		
	}
}