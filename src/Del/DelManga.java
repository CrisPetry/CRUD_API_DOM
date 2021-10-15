package Del;

import com.sun.org.apache.xml.internal.serialize.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * @author xSandman
 */
public class DelManga {

    static public void main(String[] argv) {
        try {
            DocumentBuilderFactory b = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = b.newDocumentBuilder();
            Document myDoc = builder.parse("mangas.xml");
            remove(myDoc);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
    }

    private static void remove(Document doc) throws FileNotFoundException, IOException {
        Scanner leitura = new Scanner(System.in);
        int pos = -1;

        System.out.print("Informe o numero do manga a remover: ");
        String numero = leitura.nextLine();

        NodeList nl = doc.getElementsByTagName("manga");

        for (int i = 0; i < nl.getLength(); i++) {
            pos = i;
        }

        if (pos == -1) {
            System.out.println("manga nao localizada!");
            return;
        }

        Element excluir = (Element) doc.getElementsByTagName("manga").item(pos);

        excluir.getParentNode().removeChild(excluir);

        XMLSerializer serializer = new XMLSerializer(
                new FileOutputStream("mangas.xml"), new OutputFormat(doc, "iso-8859-1", true));
        serializer.serialize(doc);
    }
}
