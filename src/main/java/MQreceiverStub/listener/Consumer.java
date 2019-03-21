package MQreceiverStub.listener;

import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class Consumer {

    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "inmemory.queue")
    public void listener() throws Exception {

        Message msg = (Message) jmsTemplate.receive("inmemory.queue");
        System.out.println("Message fpom queue" + msg);
//
//        if (msg instanceof TextMessage) {
//            System.out.println(((TextMessage) msg).getText());
//        } else {
//            System.out.println("Message type not supported");
//        }

}
    @JmsListener(destination = "inmemory.queue")
    public void listenerWithArg(String message) {
        System.out.println("Received Message: " + message);
    }

}


