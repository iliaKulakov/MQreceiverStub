package MQreceiverStub;

import MQreceiverStub.listener.Consumer;
import MQreceiverStub.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@SpringBootApplication
@EnableJms
public class MSenderStub implements ApplicationRunner {

    @Autowired
    private Sender sender;

    @Autowired
    private Consumer consumer;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MSenderStub.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.sendMessage();
//        sender.sendSecondSystemMessage();
//        consumer.listener();

    }

}
