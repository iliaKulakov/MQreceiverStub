package jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SenderWithoutSpring  {


    public void sendMessage() throws Exception{
        Context context = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) context.lookup("SampleConnectionFactory");
        Destination queue = (Destination) context.lookup("mq.xml.out");

        Connection connection = cf.createConnection();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage("Test_without_Spring");
        producer.send(message);

    }

    public static void main(String[] args) throws Exception{

        System.out.println("Hello World");

        SenderWithoutSpring senderWithoutSpring = new SenderWithoutSpring();
        senderWithoutSpring.sendMessage();
    }


}
