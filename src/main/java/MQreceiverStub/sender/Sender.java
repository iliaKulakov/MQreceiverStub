package MQreceiverStub.sender;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;
import javax.print.attribute.standard.MediaSize;


@Service
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @Autowired
    ActiveMQConnectionFactory activeMQConnectionFactory;

    public void send(String message) {
        jmsTemplate.convertAndSend(queue,message);

        System.out.println("Sent message succesfully");
    }


    public void sendMessage() throws Exception {


//        Session session = activeMQConnectionFactory.createConnection().createSession();
//        TextMessage message = session.createTextMessage();
        String msg_text = "FirstProcessingSystemRq\n" +
                            "System=1";

//        message.setText(msg_text);     // msg_text is a String

        jmsTemplate.convertAndSend(queue,msg_text);

        System.out.println("Sent message succesfully");
    }

    public void sendSecondSystemMessage() throws Exception {

        String msg_text = "SecondProcessingSystemRq\n" +
                "System=2";

        jmsTemplate.convertAndSend(queue,msg_text);

        System.out.println("Sent message succesfully");
    }



}
