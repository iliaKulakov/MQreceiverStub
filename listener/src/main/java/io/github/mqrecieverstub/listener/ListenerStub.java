package io.github.mqrecieverstub.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.mqrecieverstub.listener")
public class ListenerStub {

    public static void main(String[] args) {
        SpringApplication.run(ListenerStub.class, args);
    }

}
