package jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SendMessageAndNotToUseSpring {

    private static final String Q_CONNECTION_FACTORY = "QueueConnectionFactory";
    private static final String Q_NAME = "mq.xml.out";
    private static Context jndiContext = null;
    private static QueueConnectionFactory queueConnectionFactory = null;
    public static void main(String... args) {
        QueueConnection queueConnection = null;
        QueueSession queueSession = null;
        Queue queue = null;
        QueueSender queueSender = null;
        TextMessage message = null;
        final int NUM_MSGS;
        try {
            jndiContext = new InitialContext();
            queueConnectionFactory = (QueueConnectionFactory) jndiContext.lookup(Q_CONNECTION_FACTORY);
            queue = (Queue) jndiContext.lookup(Q_NAME);
        }catch (NamingException e) {
            System.out.println("Could not create JNDI context: " + e.getMessage());
            System.exit(1);
        }
        try {
            queueConnection = queueConnectionFactory.createQueueConnection();
            queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            queueSender = queueSession.createSender(queue);
            message = queueSession.createTextMessage();
            for (int i = 0; i < 10; i++) {
                message.setText("Test Message " + ++i);
                System.out.println("message to send: " + message.getText());
                queueSender.send(message);
            }
        } catch (JMSException e) {
            System.out.println(e.getMessage());
        } finally {
            if (null != queueConnection) {
                try {
                    queueConnection.close();
                } catch (JMSException e) {}
            }
        }
    }
}
