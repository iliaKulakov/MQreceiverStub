package io.github.mqrecieverstub.listener.configuration;

import io.github.mqrecieverstub.listener.jms.MessageProcessingListener;
import io.github.mqrecieverstub.listener.sender.SenderAnswerBackImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@EnableJms
@EnableJpaRepositories(basePackages = "io.github.mqrecieverstub.listener.repository")
@Configuration
public class AppConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${application.default.queue}")
    private String defaultQueue;

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
        factory.setConcurrency("3-10");
        return factory;
    }

    @Bean
    public MessageProcessingListener messageProcessingListener() {
        return new MessageProcessingListener();
    }

    @Bean
    public DefaultMessageListenerContainer jmsMessageListenerContainer() {
        SimpleJmsListenerEndpoint endpoint =
                new SimpleJmsListenerEndpoint();
        endpoint.setMessageListener(messageProcessingListener());
        endpoint.setDestination(defaultQueue);

        return jmsListenerContainerFactory()
                .createListenerContainer(endpoint);
    }

}
