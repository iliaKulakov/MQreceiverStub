package sender.jms;

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


    public void send(String message) {
        jmsTemplate.convertAndSend(queue, message);

        System.out.println("Sent message succesfully from Sender");
    }


}
