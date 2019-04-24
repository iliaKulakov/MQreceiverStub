package jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class SendMessageWithourSpring {

    private ConnectionFactory factory = null;

    private Connection connection = null;

    private Session session = null;

    private Destination destination = null;

    private MessageProducer messageProducer;

    public SendMessageWithourSpring() {
    }

    public void sendMessage() {
        try
        {
            factory = new ActiveMQConnectionFactory( ActiveMQConnection.DEFAULT_BROKER_URL );
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession( false, session.AUTO_ACKNOWLEDGE );
            destination = session.createQueue( "mq.xml.out" );
            messageProducer = session.createProducer( destination );
            TextMessage message = session.createTextMessage();
            message.setText( "Hello...This is message from client" );

            messageProducer.send( message );
            System.out.println( "Sent Message: " + message.getText() );
        }
        catch ( JMSException e )
        {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        SendMessageWithourSpring sender = new SendMessageWithourSpring();
        sender.sendMessage();
    }

}


