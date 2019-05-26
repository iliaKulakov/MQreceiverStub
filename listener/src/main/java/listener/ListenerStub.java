package listener;

import listener.controller.Controller;
//import listener.controller.repo.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@Configuration
@SpringBootApplication(scanBasePackages = "listener")
@EnableJms
@EnableJpaRepositories
@EntityScan(value = "listener.controller.domain.BankSystemsDomain")
public class ListenerStub implements ApplicationRunner {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ListenerStub.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Listener working now ");

    }


}
