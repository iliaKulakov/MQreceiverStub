package listener.service;

import listener.Parsing.Parser;
import listener.controller.domain.BankSystemsDomain;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Service
public class MessageHandling {

    public static String prepareAnswerToSender(String message) throws Exception{
        String messageForProcessing = message;


        Document doc =  Parser.convertStringToXMLDocument(messageForProcessing);

        doc.getDocumentElement().getElementsByTagName("currency").item(0).setTextContent("RUR");

        NodeList docElements = doc.getDocumentElement().getElementsByTagName("config");

        for (int i = 0; i < docElements.getLength(); i++) {
            Node elements = docElements.item(i);
            NamedNodeMap attributes = elements.getAttributes();
            attributes.getNamedItem("currency");

        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
        return output;

    }


//    public static void main(String args[]) throws Exception{
//
//        final String message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<config>\n" +
//                "    <item date=\"January 2009\">\n" +
//                "        <mode>1</mode>\n" +
//                "        <reqamt>900</reqamt>\n" +
//                "        <currency>EUR</currency>\n" +
//                "        <interactive>Ok</interactive>\n" +
//                "    </item>\n" +
//                "</config>";
//        prepareAnswerToSender(message);
//
//
//    }
}
