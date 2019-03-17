package MQreceiverStub.services;

import MQreceiverStub.MQreceiverStub;
import MQreceiverStub.listener.MessageListener;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ProductServiceImpl implements ProductService {

//    private static final Logger log = LogManager.getLogger(MessageListener.class);

    @Autowired
    private JmsTemplate jmsTemplate;


    @Override
    public void sendMessage(String id) {
        Map<String, String> actionmap;
        actionmap = new HashMap<>();
        actionmap.put("id", id);
//        log.info("Sending the index request through queue message");
        jmsTemplate.convertAndSend(MQreceiverStub.PRODUCT_MESSAGE_QUEUE, actionmap);
    }

}
