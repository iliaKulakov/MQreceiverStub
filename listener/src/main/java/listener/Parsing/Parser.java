package listener.Parsing;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class Parser {

    public static Document convertStringToXMLDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<config>\n" +
                "    <item date=\"January 2009\">\n" +
                "        <mode>1</mode>\n" +
                "        <reqamt>900</reqamt>\n" +
                "        <currency>EUR</currency>\n" +
                "        <interactive>Ok</interactive>\n" +
                "    </item>\n" +
                "</config>";

        Document doc = convertStringToXMLDocument(xmlStr);

        NodeList docElements = doc.getDocumentElement().getElementsByTagName("config");

        for (int i = 0; i < docElements.getLength(); i++) {
            Node elements = docElements.item(i);
            NamedNodeMap attributes = elements.getAttributes();
            attributes.getNamedItem("currency");

            System.out.println(doc.getFirstChild().getNodeName() + attributes.getNamedItem("currency"));
        }




    }

    public boolean canBeParse(Document doc) {
        Document docForParse = doc;
        return true;
    }
}
