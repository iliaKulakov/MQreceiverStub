package MQreceiverStub;

import MQreceiverStub.sender.Sender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
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

// Это лишнее @SpringBootApplication уже включает это. https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-using-springbootapplication-annotation.html

//@ComponentScan
@EnableJms
public class MQreceiverStub implements ApplicationRunner {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Autowired
    public Sender sender;


    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("inmemory.queue");
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(MQreceiverStub.class, args);


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.send("111");
    }

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector(brokerUrl);
        broker.setPersistent(false);
        return broker;
    }

    //Config for JmsListener
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory());
//        factory.setMessageConverter(messageConverter());
        factory.setConcurrency("3-10");
        return factory;
    }

//    @Bean
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(activeMQConnectionFactory());
//    }

}
