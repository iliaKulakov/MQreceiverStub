package MQreceiverStub;

import MQreceiverStub.sender.Sender;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Configuration
@SpringBootApplication
@ComponentScan
@EnableJms
public class MQreceiverStub implements CommandLineRunner {


	@Bean
	public ActiveMQQueue queue()
	{
		return new ActiveMQQueue("inmemory.queue");
	}


	@Autowired
    Sender sender;


	public static void main(String[] args) {
		SpringApplication.run(MQreceiverStub.class, args);

//	Sender sender = new Sender();
//	sender.publishMessage();

	}


    @Override
    public void run(String... args) throws Exception {

	    sender.publishMessage();

    }


}
