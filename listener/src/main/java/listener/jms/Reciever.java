package listener.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

    @JmsListener(destination = "mq.stub.out")
    public void listenerWithArg(String message) {
        System.out.println("Received Message: " + message);
    }


}
