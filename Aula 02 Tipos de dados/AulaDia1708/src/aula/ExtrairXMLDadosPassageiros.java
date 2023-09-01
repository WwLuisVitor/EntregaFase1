package aula;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ExtrairXMLDadosPassageiros {
	 public static void main(String[] args) {
	        try {
	            File inputFile = new File("passageiros.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(inputFile);

	            doc.getDocumentElement().normalize();

	            NodeList nodeList = doc.getElementsByTagName("passageiro");

	            for (int i = 0; i < nodeList.getLength(); i++) {
	                Node node = nodeList.item(i);

	                if (node.getNodeType() == Node.ELEMENT_NODE) {
	                    Element element = (Element) node;
	                 
	                    String origemedestino = element.getElementsByTagName("origemedestino").item(0).getTextContent();
	                    System.out.println("A origem e destino dos passageiros são: " + origemedestino);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
