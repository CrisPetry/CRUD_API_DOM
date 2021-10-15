package Edit;

import com.sun.org.apache.xml.internal.serialize.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author xSandman
 */
public class EditManga {

    static public void main(String[] argv) {
        try {
            DocumentBuilderFactory b = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = b.newDocumentBuilder();
            Document myDoc = builder.parse("mangas.xml");
            edita(myDoc);
        } catch (IOException | ParserConfigurationException | TransformerException | SAXException e) {
            System.out.println(e.toString());
        }
    }

    private static void edita(Document doc) throws TransformerException, IOException {
        Scanner leitura = new Scanner(System.in);
        int pos = -1;

        System.out.print("Informe o numero do mangá a editar: ");
        String numero = leitura.nextLine();

        NodeList nl = doc.getElementsByTagName("manga");

        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getAttributes().item(0).getNodeValue().equals(numero)) {
                pos = i;
            }
        }

        if (pos == -1) {
            System.out.println("Manga nao localizado!");
            return;
        }

        System.out.print("Informe o titulo: ");
        doc.getElementsByTagName("titulo").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe a categoria: ");
        doc.getElementsByTagName("categoria").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o preço: ");
        doc.getElementsByTagName("preco").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o ano de lançamento: ");
        doc.getElementsByTagName("ano_lancamento").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o nome do autor(a): ");
        doc.getElementsByTagName("nomeAutor").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe a idade: ");
        doc.getElementsByTagName("idade").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe o nome da editora: ");
        doc.getElementsByTagName("nome").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe logradouro: ");
        doc.getElementsByTagName("logradouro").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe cidade: ");
        doc.getElementsByTagName("cidade").item(pos).setTextContent(leitura.nextLine());
        System.out.print("Informe estado: ");
        doc.getElementsByTagName("estado").item(pos).setTextContent(leitura.nextLine());

        doc.createComment("Mangá editado via CRUD");

        XMLSerializer serializer = new XMLSerializer(
                new FileOutputStream("mangas.xml"), new OutputFormat(doc, "iso-8859-1", true));
        serializer.serialize(doc);
    }
}
