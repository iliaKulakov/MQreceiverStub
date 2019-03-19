package MQreceiverStub.sender;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static MQreceiverStub.MQreceiverStub.PRODUCT_MESSAGE_QUEUE;


@EnableJms
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ActiveMQQueue queue;

//    public void publishMessage() throws Exception{
//        jmsTemplate.send((Destination) queue, s -> s.createTextMessage("hello queue world"));
//
//        System.out.println("Successfully publish");
//    }

    public void publishMessage() throws Exception{
        jmsTemplate.send((Destination) queue, s -> s.createTextMessage("hello queue world"));

        System.out.println("Successfully publish");
    }

}
