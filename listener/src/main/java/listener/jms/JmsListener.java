package listener.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsListener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @org.springframework.jms.annotation.JmsListener(destination = "inmemory.queue")
    public void listener(String message) {

//        Message msg = (Message) jmsTemplate.receive("inmemory.queue");

        System.out.println("Message from queue" + message);

    }
    @org.springframework.jms.annotation.JmsListener(destination = "inmemory.queue")
    public void listenerWithArg(String message) {
        System.out.println("Received Message: " + message);


    }

}
