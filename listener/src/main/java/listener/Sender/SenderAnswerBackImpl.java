package listener.Sender;


import listener.service.MessageHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class SenderAnswerBackImpl implements  Sender {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Autowired
    MessageHandling messageHandling;

    private String queue = "mq.xml.in";


    @Override
    public void sendMessage(String message) throws Exception{

        String messageAnswer = messageHandling.prepareAnswerToSender(message);

        jmsTemplate.convertAndSend(queue, messageAnswer);
        System.out.println("Sent message succesfully" + messageAnswer);

    }

}
