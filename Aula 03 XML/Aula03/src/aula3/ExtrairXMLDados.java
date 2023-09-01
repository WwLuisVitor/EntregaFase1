package aula3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ExtrairXMLDados {
    public static void main(String[] args) {
        try {
            File inputFile = new File("passageiros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("passageiro");

            int numPassageiros = nodeList.getLength();
            System.out.println("Número de passageiros: " + numPassageiros);
            System.out.println("Origens e destinos:");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String origem = element.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = element.getElementsByTagName("destino").item(0).getTextContent();
                    

                    System.out.println("Passageiro " + (i + 1) + ":");
                    System.out.println("Origem: " + origem);
                    System.out.println("Destino: " + destino);
                  
                    System.out.println("-------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
