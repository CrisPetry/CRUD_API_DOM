package add;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author xSandman
 */
public class AddManga {

    static public void main(String[] argv) {
        try {
            DocumentBuilderFactory b = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = b.newDocumentBuilder();
            Document myDoc = builder.parse("mangas.xml");
            adiciona(myDoc);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void adiciona(Document doc) throws IOException, TransformerException {
        Element mangas, manga, titulo, categoria, preco, ano_lancamento, autor, nomeAutor, idade, editora, nome, endereco, logradouro, cidade, estado;
        Scanner leitura = new Scanner(System.in);

        mangas = (Element) doc.getElementsByTagName("mangas").item(0);

        manga = doc.createElement("manga");

        //define atributo e adiciona ao elemento
        System.out.print("Informe o numero do manga: ");
        manga.setAttribute("numero", leitura.nextLine());

        // define subelementos de manga
        titulo = doc.createElement("titulo");
        System.out.print("Informe o titulo: ");
        titulo.appendChild(doc.createTextNode(leitura.nextLine()));
        manga.appendChild(titulo);

        categoria = doc.createElement("categoria");
        System.out.print("Informe a categoria: ");
        categoria.appendChild(doc.createTextNode(leitura.nextLine()));
        manga.appendChild(categoria);

        preco = doc.createElement("preco");
        System.out.print("Informe o preco: ");
        preco.appendChild(doc.createTextNode(leitura.nextLine()));
        manga.appendChild(preco);

        ano_lancamento = doc.createElement("ano_lancamento");
        System.out.print("Informe o ano: ");
        ano_lancamento.appendChild(doc.createTextNode(leitura.nextLine()));
        manga.appendChild(ano_lancamento);

        //define elemento e subelementos
        autor = doc.createElement("autor");
        nomeAutor = doc.createElement("nomeAutor");
        System.out.print("Informe o nome do autor: ");
        nomeAutor.appendChild(doc.createTextNode(leitura.nextLine()));

        idade = doc.createElement("idade");
        System.out.print("Informe a idade: ");
        idade.appendChild(doc.createTextNode(leitura.nextLine()));

        editora = doc.createElement("editora");
        nome = doc.createElement("nome");
        System.out.print("Informe o nome da editora: ");
        nome.appendChild(doc.createTextNode(leitura.nextLine()));

        endereco = doc.createElement("endereco");
        logradouro = doc.createElement("logradouro");
        System.out.print("Informe o logradouro: ");
        logradouro.appendChild(doc.createTextNode(leitura.nextLine()));

        cidade = doc.createElement("cidade");
        System.out.print("Informe a cidade: ");
        cidade.appendChild(doc.createTextNode(leitura.nextLine()));
        endereco.appendChild(cidade);

        estado = doc.createElement("estado");
        System.out.print("Informe o estado: ");
        estado.appendChild(doc.createTextNode(leitura.nextLine()));
        endereco.appendChild(estado);

        endereco.appendChild(logradouro);
        endereco.appendChild(cidade);
        endereco.appendChild(estado);
        editora.appendChild(nome);
        editora.appendChild(endereco);
        autor.appendChild(nomeAutor);
        autor.appendChild(idade);
        manga.appendChild(autor);
        manga.appendChild(editora);

        mangas.appendChild(manga);

        mangas.appendChild(doc.createComment("Arquivo gerado por CRUD"));

        //serializa documento para arquivo
        XMLSerializer serializer = new XMLSerializer(
                new FileOutputStream("mangas.xml"), new OutputFormat(doc, "iso-8859-1", true));
        serializer.serialize(doc);
    }
}
