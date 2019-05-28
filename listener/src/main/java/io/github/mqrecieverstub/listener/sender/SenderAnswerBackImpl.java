package io.github.mqrecieverstub.listener.sender;


import io.github.mqrecieverstub.listener.service.MessageHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;

@Service
public class SenderAnswerBackImpl implements Sender {

    private final MessageHandling messageHandling;
    private final JmsTemplate jmsTemplate;

    @Value("${application.default.queue}")
    private String defaultQueue;

    @Autowired
    public SenderAnswerBackImpl(MessageHandling messageHandling, JmsTemplate jmsTemplate) {
        this.messageHandling = messageHandling;
        this.jmsTemplate = jmsTemplate;
    }


    @Override
    public void sendMessage(String message) throws TransformerException {

        String messageAnswer = messageHandling.prepareAnswerToSender(message);

        jmsTemplate.convertAndSend(defaultQueue, messageAnswer);
        System.out.println("Sent message succesfully" + messageAnswer);

    }

}
