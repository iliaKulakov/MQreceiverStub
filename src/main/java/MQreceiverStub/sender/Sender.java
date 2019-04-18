package MQreceiverStub.sender;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;


@Service
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private ActiveMQConnectionFactory activeMQConnectionFactory;

    public void send(String message) {
        jmsTemplate.convertAndSend(queue, message);

        System.out.println("Sent message succesfully");
    }


    public void sendMessage() throws Exception {

        String msg_text = "FirstProcessingSystemRq\n" +
                "System=1";

        jmsTemplate.convertAndSend(queue, msg_text);

        System.out.println("Sent message succesfully");
    }

    public void sendSecondSystemMessage() throws Exception {

        String msg_text = "SecondProcessingSystemRq\n" +
                "System=2";

        jmsTemplate.convertAndSend(queue, msg_text);

        System.out.println("Sent message succesfully");
    }


}
