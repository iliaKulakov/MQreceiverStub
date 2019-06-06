package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.domain.BankSystemInfo;
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

        Document xmlDocumentMessage = parser.convertStringToXMLDocument(messageForProcessing);

        //is it correct realisation for choose answer?

        BankSystemInfo bankSystemInfo = configProcessing.getConfigInfoFromDb();
        Node currencyNode = this.getCurrencyNode(xmlDocumentMessage);

//        TODO: Можно делать например так, или можно сделать через switch если значение с которым сравниывешь является константой или значемем из enum.

//        switch (bankSystemInfo.getBankSystemOne()) {
//            case 0:
//                currencyNode.setTextContent("JAR");
//                break;
//                default:
//                    currencyNode.setTextContent("USD");
//                    break;
//        }

        if (bankSystemInfo.getBankSystemOne() == bankSystemInfo.getDefaultBankSystemOne()) {
            currencyNode.setTextContent("JAR");
        } else {
            currencyNode.setTextContent("USD");
        }

        NodeList docElements = xmlDocumentMessage.getDocumentElement().getElementsByTagName("config");

        for (int i = 0; i < docElements.getLength(); i++) {
            Node elements = docElements.item(i);
            NamedNodeMap attributes = elements.getAttributes();
            attributes.getNamedItem("currency");

        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(xmlDocumentMessage), new StreamResult(writer));
        return writer.getBuffer().toString().replaceAll("\n|\r", "");
    }

    private Node getCurrencyNode(Document document) {

        String elementName = "currency";
        int firstElementOfCurrencyNode = 0;

        Node currencyTypeNode = document.getDocumentElement().getElementsByTagName(elementName).item(firstElementOfCurrencyNode);

        return currencyTypeNode;
    }
}
