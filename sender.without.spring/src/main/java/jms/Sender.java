package jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {


    public void sendMessageWithoutSpring() throws Exception {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create a Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        Destination destination = session.createQueue("mq.xml.out");

        // Create a MessageProducer from the Session to the Topic or Queue
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // Create a messages
        String text = "?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<config>\n" +
                "    <item date=\"January 2009\">\n" +
                "        <mode>1</mode>\n" +
                "        <reqamt>900</reqamt>\n" +
                "        <currency>EUR</currency>\n" +
                "        <interactive>1</interactive>\n" +
                "    </item>\n" +
                "</config>";
        TextMessage message = session.createTextMessage(text);

        // Tell the producer to send the message
        System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
        System.out.println("Sent message: " + message.getText() + " : " + Thread.currentThread().getName());
        producer.send(message);

        // Clean up
        session.close();
        connection.close();
    }

}



