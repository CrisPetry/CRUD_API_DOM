package Consult;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author xSandman
 */
public class ConsultManga {

    public static void main(String[] argv) {
        try {
            File xmlDoc = new File("mangas.xml");
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFact.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlDoc);

            NodeList nl = doc.getElementsByTagName("manga");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                System.out.println("---------------------------------------------------");
                System.out.println(n.getNodeName() + " número" + " " + (i + 1));
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;

                    System.out.println("Titulo: "
                            + e.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Categoria: "
                            + e.getElementsByTagName("categoria").item(0).getTextContent());
                    System.out.println("Preço: "
                            + e.getElementsByTagName("preco").item(0).getTextContent());
                    System.out.println("Ano: "
                            + e.getElementsByTagName("ano_lancamento").item(0).getTextContent());
                    System.out.println("Autor: "
                            + e.getElementsByTagName("nomeAutor").item(0).getTextContent());
                    System.out.println("Idade: "
                            + e.getElementsByTagName("idade").item(0).getTextContent());
                    System.out.println("Editora: "
                            + e.getElementsByTagName("nome").item(0).getTextContent());
                    System.out.println("Logradouro: "
                            + e.getElementsByTagName("logradouro").item(0).getTextContent());
                    System.out.println("Cidade: "
                            + e.getElementsByTagName("cidade").item(0).getTextContent());
                    System.out.println("Estado: "
                            + e.getElementsByTagName("estado").item(0).getTextContent());

                }
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
    }

}
