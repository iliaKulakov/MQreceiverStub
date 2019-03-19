package MQreceiverStub.listener;

import MQreceiverStub.MQreceiverStub;
import org.apache.logging.log4j.LogManager;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Logger;

@Component
public class Consumer {

    @JmsListener(destination = "inmemory.queue")
    public void listener(String message){
        System.out.println("Received Message: " + message);
    }

}