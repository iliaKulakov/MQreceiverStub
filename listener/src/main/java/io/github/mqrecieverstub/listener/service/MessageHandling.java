package io.github.mqrecieverstub.listener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Service
public class MessageHandling {

    private final Parser parser;

    private ConfigProcessing configProcessing;


    @Autowired
    public MessageHandling(Parser parser, ConfigProcessing configProcessing) {
        this.parser = parser;
        this.configProcessing = configProcessing;
    }

    public String prepareAnswerToSender(String messageForProcessing) throws TransformerException {

        Document doc = parser.convertStringToXMLDocument(messageForProcessing);

        //is it correct realisation for choose answer?
        if (configProcessing.getConfigInfoFromDb().getBankSystemOne() == 0) {

            doc.getDocumentElement().getElementsByTagName("currency").item(0).setTextContent("JAR");
        } else {
            doc.getDocumentElement().getElementsByTagName("currency").item(0).setTextContent("USD");
        }

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
        return writer.getBuffer().toString().replaceAll("\n|\r", "");

    }
}
