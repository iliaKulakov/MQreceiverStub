package io.github.mqrecieverstub.listener;

import io.github.mqrecieverstub.listener.controller.domain.BankSystemsDomain;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;


@Configuration
@SpringBootApplication(scanBasePackages = "io.github.mqrecieverstub.listener")
@EnableJms
@EnableJpaRepositories
public class ListenerStub {

    public static void main(String[] args) {
        SpringApplication.run(ListenerStub.class, args);
    }

}
