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

    public static void main(String[] args) {
        SpringApplication.run(SenderStub.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

//        String xmlMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<config>\n" +
//                "    <item date=\"January 2009\">\n" +
//                "        <mode>1</mode>\n" +
//                "        <reqamt>900</reqamt>\n" +
//                "        <currency>EUR</currency>\n" +
//                "        <interactive>1</interactive>\n" +
//                "    </item>\n" +
//                "</config>";



        sender.send("hello");

    }

}
