import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.NORM_PRIORITY;

public class SampleServer {

    Socket s;
    int num;

    public SampleServer(int num, Socket s)
    {
        // копируем данные
        this.num = num;
        this.s = s;

        // и запускаем новый вычислительный поток (см. ф-ю run())
//        Thread thread = new Thread(s).setDaemon(true);
//        thread.setPriority(NORM_PRIORITY);
//        thread.start();

    }

    public void run()
    {
        try
        {
            // из сокета клиента берём поток входящих данных
            InputStream is = s.getInputStream();
            // и оттуда же - поток данных от сервера к клиенту
            OutputStream os = s.getOutputStream();

            // буффер данных в 64 килобайта
            byte buf[] = new byte[64*1024];
            // читаем 64кб от клиента, результат - кол-во реально принятых данных
            int r = is.read(buf);

            // создаём строку, содержащую полученную от клиента информацию
            String data = new String(buf, 0, r);

            // добавляем данные об адресе сокета:
            data = ""+num+": "+"\n"+data;

            // выводим данные:
            os.write(data.getBytes());

            // завершаем соединение
            s.close();
        }
        catch(Exception e)
        {System.out.println("init error: "+e);} // вывод исключений
    }


    public static void main(String args[])
    {
        try
        {
            int i = 0; // счётчик подключений
            ServerSocket server = new ServerSocket(3128, 0,
                    InetAddress.getByName("localhost"));

            System.out.println("server is started");

            // слушаем порт
            while(true)
            {
                new SampleServer(i, server.accept());
                i++;
            }
        }
        catch(Exception e)
        {System.out.println("init error: "+e);} // вывод исключений
    }
}
