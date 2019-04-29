
import jms.Reader;
import SenderConcurrencyRealisation.SenderWithConcurrency;

public class AppRunner {

    public static void main(String[] args) throws Exception {

//        Sender sender = new Sender();
//        Sender sender1 = new Sender();
//        sender.sendMessageWithoutSpring();
//        sender1.sendMessageWithoutSpring();

        SenderWithConcurrency senderWithConcurrency = new SenderWithConcurrency();
        senderWithConcurrency.run();

        Reader reader = new Reader();
        reader.readMessageWithoutSpring();

    }

}
