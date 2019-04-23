package listener.Parsing;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class Parser {

    String xmlMessage =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<config>\n" +
            "    <item date=\"January 2009\">\n" +
            "        <mode>1</mode>\n" +
            "        <reqamt>900</reqamt>\n" +
            "        <currency>EUR</currency>\n" +
            "        <interactive>1</interactive>\n" +
            "    </item>\n" +
            "</config>";

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(xmlMessage);
    doc.

         doc.getDocumentElement().normalize();

}
