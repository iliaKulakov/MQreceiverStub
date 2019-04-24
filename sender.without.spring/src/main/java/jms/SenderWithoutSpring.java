package jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class SenderWithoutSpring  {


    public void sendMessage() throws Exception{

        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://hostname:61616");
        javax.naming.Context ctx = new InitialContext(props);

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



        SenderWithoutSpring senderWithoutSpring = new SenderWithoutSpring();
        senderWithoutSpring.sendMessage();
    }


}
