package listener.jms;

import listener.Sender.SenderAnswerBackImpl;
import listener.service.MessageHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
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
