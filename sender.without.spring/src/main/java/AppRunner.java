

import jms.Reader;
import SenderConcurrencyRealisation.SenderWithConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AppRunner {

    public static void main(String[] args) throws Exception {

//        Sender sender = new Sender();
//        Sender sender1 = new Sender();
//        sender.sendMessageWithoutSpring();
//        sender1.sendMessageWithoutSpring();

        SenderWithConcurrency senderWithConcurrency = new SenderWithConcurrency();
//        senderWithConcurrency.run();

        Reader reader = new Reader();
        reader.readMessageWithoutSpring();

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            threadPool.execute(senderWithConcurrency);

        }

    }

}
