package MQreceiverStub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MQreceiverStub {

	public static void main(String[] args) {
		SpringApplication.run(MQreceiverStub.class, args);
	}

}
