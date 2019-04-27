package jms;

import javax.jms.JMSException;

public class AppRunner {

    public static void main(String[] args) throws Exception {

        Sender sender = new Sender();
        sender.sendMessageWithoutSpring();

        Reader reader = new Reader();
        reader.readMessageWithoutSpring();

    }

}
