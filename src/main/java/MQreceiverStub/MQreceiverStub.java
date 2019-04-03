package MQreceiverStub;

import MQreceiverStub.listener.Consumer;
import MQreceiverStub.sender.Sender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.Connection;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageType;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Configuration
@SpringBootApplication
@EnableJms
public class MQreceiverStub implements ApplicationRunner {

    @Autowired
    public Sender sender;

    @Autowired
    Consumer consumer;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MQreceiverStub.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.sendMessage();
        sender.sendSecondSystemMessage();
        consumer.listener();

    }

}
