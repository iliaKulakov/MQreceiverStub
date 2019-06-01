package io.github.mqrecieverstub.listener;

import io.github.mqrecieverstub.listener.jms.MessageProcessingListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "io.github.mqrecieverstub.listener")
@EnableTransactionManagement
@EnableJms
public class ListenerStub {

    @Autowired
    MessageProcessingListener messageProcessingListener;

    public static void main(String[] args) {
        SpringApplication.run(ListenerStub.class, args);
    }

}
