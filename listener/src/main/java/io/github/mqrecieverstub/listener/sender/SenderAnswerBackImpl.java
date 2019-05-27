package io.github.mqrecieverstub.listener.sender;


import io.github.mqrecieverstub.listener.service.MessageHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderAnswerBackImpl implements Sender {

    @Autowired
    MessageHandling messageHandling;
    @Autowired
    private JmsTemplate jmsTemplate;
    private String queue = "mq.xml.in";


    @Override
    public void sendMessage(String message) throws Exception {

        String messageAnswer = messageHandling.prepareAnswerToSender(message);

        jmsTemplate.convertAndSend(queue, messageAnswer);
        System.out.println("Sent message succesfully" + messageAnswer);

    }

}
