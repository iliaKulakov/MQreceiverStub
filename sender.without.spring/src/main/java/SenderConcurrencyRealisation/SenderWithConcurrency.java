package SenderConcurrencyRealisation;

import jms.Sender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.JmsException;

import javax.jms.*;

public class SenderWithConcurrency implements Runnable{

    Thread thread;

    public SenderWithConcurrency() {

           thread = new Thread(this, "Example thread - sent message");
           thread.start();
        }

    @Override
    public void run() {

        try{
        Sender sender = new Sender();
        sender.sendMessageWithoutSpring();}
        catch (Exception e){
            System.out.println(e);
        }

    }




}
