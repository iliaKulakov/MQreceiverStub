package sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sender.jms.Sender;

@SpringBootApplication
public class SenderStub implements ApplicationRunner {


    @Autowired
    private Sender sender;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SenderStub.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.sendMessage();

    }

}
