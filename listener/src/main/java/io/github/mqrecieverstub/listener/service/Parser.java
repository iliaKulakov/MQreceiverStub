package io.github.mqrecieverstub.listener.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@Service
public class Parser {

    Document convertStringToXMLDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document resultDocument = null;
        try {
            builder = factory.newDocumentBuilder();

            resultDocument = builder.parse(new InputSource(new StringReader(xmlStr)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDocument;
    }

}
