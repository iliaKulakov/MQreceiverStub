package io.github.mqrecieverstub.listener.jms;

import io.github.mqrecieverstub.listener.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MessageProcessingListener implements MessageListener {

    @Autowired
    private Sender senderAnswerBack;

    @Override
    public void onMessage(Message message) {


        if (message instanceof TextMessage) {
            try {

                String messageBody = ((TextMessage) message).getText();
                System.out.println("Received Message: " + messageBody);
                System.out.println("Preparing to answer");
                senderAnswerBack.sendMessage(messageBody);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
