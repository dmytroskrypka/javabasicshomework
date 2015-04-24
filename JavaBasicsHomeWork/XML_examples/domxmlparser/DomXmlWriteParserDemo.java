package domxmlparser;


import org.w3c.dom.Document;
import org.w3c.dom.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Demonstrates how to use xml DOM parser
 */
public class DomXmlWriteParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("catalog");
        document.appendChild(root);

        //book 1
        Element book1 = document.createElement("book1");
        root.appendChild(book1);

        Element author1 = document.createElement("author");
        author1.setTextContent("Gambardella, Matthew");
        book1.appendChild(author1);

        //book 2
        Element book2 = document.createElement("book2");
        root.appendChild(book2);

        Element author2 = document.createElement("author");
        author2.setTextContent("Ralls, Kim");
        book2.appendChild(author2);

        //save
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("C:\\Temp\\output.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result); //TransformerException
    }
}
