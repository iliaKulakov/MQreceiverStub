package jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Reader {

    public void  readMessageWithoutSpring() throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create a Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        Destination destination = session.createQueue("mq.xml.in");

        // create a queue receiver
       MessageConsumer queueReceiver = session.createConsumer(destination);

       // receive a message
       TextMessage message = (TextMessage) queueReceiver.receive();

       // print the message
       System.out.println("received message: " + message.getText());

      // close the queue connection
       connection.close();


    }
}



