package listener.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

    @JmsListener(destination = "mq.xml.out")
    @SendTo("mq.xml.in")
    public String listenerWithArg(String message) {
        System.out.println("Received Message: " + message);

        String messageAnswer = message;
        messageAnswer.toUpperCase(); //need to test

        return messageAnswer;

    }


}
