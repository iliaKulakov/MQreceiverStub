package io.github.mqrecieverstub.listener;

import io.github.mqrecieverstub.listener.service.ConfigHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "io.github.mqrecieverstub.listener")
@EnableTransactionManagement
public class ListenerStub {

    public static void main(String[] args) {
        SpringApplication.run(ListenerStub.class, args);



    }

}
