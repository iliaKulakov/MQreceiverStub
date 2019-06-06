package io.github.mqrecieverstub.listener;

import io.github.mqrecieverstub.listener.jms.MessageProcessingListener;
import io.github.mqrecieverstub.listener.service.ConfigProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "io.github.mqrecieverstub.listener")
@EnableTransactionManagement
@EnableJms
public class ListenerStub implements ApplicationRunner {

    @Autowired
    MessageProcessingListener messageProcessingListener;

    @Autowired
    ConfigProcessing configProcessing;

    public static void main(String[] args) {
        SpringApplication.run(ListenerStub.class, args);
    }

    public void run(ApplicationArguments args) throws Exception {

        configProcessing.putDefaultConfigInfoInDatabase();

    }


}
