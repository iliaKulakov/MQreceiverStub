

import jms.Reader;
import SenderConcurrencyRealisation.SenderWithConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AppRunner {

    public static void main(String[] args) throws Exception {

//        sender sender = new sender();
//        sender sender1 = new sender();
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
