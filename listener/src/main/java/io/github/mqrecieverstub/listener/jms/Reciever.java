package io.github.mqrecieverstub.listener.jms;

import io.github.mqrecieverstub.listener.sender.SenderAnswerBackImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

    @Autowired
    SenderAnswerBackImpl senderAnswerBack;

    @JmsListener(destination = "mq.xml.out")
    public void listenerWithArg(String message) throws Exception {
        System.out.println("Received Message: " + message);
        senderAnswerBack.sendMessage(message);

    }


}
