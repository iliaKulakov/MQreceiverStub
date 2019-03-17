package MQreceiverStub;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

@Component
public class Recv {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        ((ConnectionFactory) factory).setHost("localhost");
        Connection connection = ((ConnectionFactory) factory).newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false,false,false,null);
        System.out.println(" Waiting for messages. To exit please press CTR + C");

        DeliverCallback deliverCallback = (String consumerTag, Delivery delivery) ->
        {
            String message = new String(delivery.getBody(),"UTF-8");
            System.out.println("Received" + message + "'");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag ->{});


    }
}