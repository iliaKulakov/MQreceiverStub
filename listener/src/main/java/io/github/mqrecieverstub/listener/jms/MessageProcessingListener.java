package io.github.mqrecieverstub.listener.jms;

import io.github.mqrecieverstub.listener.sender.SenderAnswerBackImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.transform.TransformerException;

@Component
public class MessageProcessingListener implements MessageListener {

    @Autowired
    private SenderAnswerBackImpl senderAnswerBack;


    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {

                String messageBody = ((TextMessage) message).getText();
                System.out.println("Received Message: " + messageBody);
                senderAnswerBack.sendMessage(messageBody);
            } catch (JMSException | TransformerException e) {
                e.printStackTrace();
            }
        }

    }
}
