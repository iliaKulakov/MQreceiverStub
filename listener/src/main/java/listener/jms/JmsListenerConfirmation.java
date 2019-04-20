package listener.jms;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class JmsListenerConfirmation {

    @org.springframework.jms.annotation.JmsListener(destination = "mq.stub.out")
    public void listenerWithArg(String message) {
        System.out.println("Received Message: " + message);

    }


}
