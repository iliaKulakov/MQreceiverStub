package listener.jms;

import org.springframework.stereotype.Component;

@Component
public class JmsListener {

    @org.springframework.jms.annotation.JmsListener(destination = "testq")
    public void listenerWithArg(String message) {
        System.out.println("Received Message: " + message);


    }

}
