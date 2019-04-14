package listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@SpringBootApplication
@EnableJms
public class ListenerStub implements ApplicationRunner  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ListenerStub.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        sender.sendMessage();
//        sender.sendSecondSystemMessage();
//        consumer.listener();
        System.out.println("Listener working now ");
    }


}
