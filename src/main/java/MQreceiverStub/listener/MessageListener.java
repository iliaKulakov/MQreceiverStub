package MQreceiverStub.listener;

import MQreceiverStub.MQreceiverStub;
import org.apache.logging.log4j.LogManager;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Logger;

@Component
public class MessageListener {

//    private ProductRepository productRepository;

//    private static final Logger log = LogManager.getLogger(MessageListener.class);

//    public MessageListener(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }


    @JmsListener(destination = MQreceiverStub.PRODUCT_MESSAGE_QUEUE, containerFactory = "jmsFactory")
    public void receiveMessage(Map<String, String> message) {
//        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
//        Product product = productRepository.findById(id).orElse(null);
//        product.setMessageReceived(true);
//        product.setMessageCount(product.getMessageCount() + 1);
//        productRepository.save(product);
//        log.info("Message processed...");
    }

}