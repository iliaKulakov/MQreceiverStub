package listener.jms;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class JmsListener {

    @org.springframework.jms.annotation.JmsListener(destination = "testq")
    @SendTo("mq.stub.out")
    public String listenerWithArg(String message) {
        System.out.println("Received Message: " + message);

        String reply = message;

        return reply.toUpperCase();
    }




}
