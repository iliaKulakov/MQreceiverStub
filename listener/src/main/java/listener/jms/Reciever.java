package listener.jms;

import listener.service.MessageHandling;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

    @JmsListener(destination = "mq.xml.out")
    @SendTo("mq.xml.in")
    public String listenerWithArg(String message) throws Exception {
        System.out.println("Received Message: " + message);

        String messageAnswer = MessageHandling.prepareAnswerToSender(message);
        System.out.println("Answer to Sender: " + messageAnswer);

        return messageAnswer;

    }


}
