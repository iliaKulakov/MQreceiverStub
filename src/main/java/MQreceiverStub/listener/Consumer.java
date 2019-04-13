package MQreceiverStub.listener;

import MQreceiverStub.MQreceiverStub;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class Consumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "inmemory.queue")
    public void listener(String message) {

//        Message msg = (Message) jmsTemplate.receive("inmemory.queue");

        System.out.println("Message from queue" + message);

}
    @JmsListener(destination = "inmemory.queue")
    public void listenerWithArg(String message) {
        System.out.println("Received Message: " + message);


    }

}


