package concurrency.cp1;

import concurrency.cp1.application.TicketWindow;
import concurrency.cp1.application.TicketWindowRunnable;
import org.junit.Test;

/**
 * @author yanyuchi
 * @date 2020-02-24 17:41
 */

public class BasicTest {

    @Test
    public void test1(){
        TicketWindow t1 = new TicketWindow("一号");
        t1.start();
        TicketWindow t2 = new TicketWindow("二号");
        t2.start();
        TicketWindow t3 = new TicketWindow("三号");
        t3.start();
    }

    @Test
    public void runnable(){
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread t1 = new Thread(task,"NO 1");

        Thread t2 = new Thread(task,"NO 2");

        Thread t3 = new Thread(task,"NO 3");

        t1.start();
        t2.start();
        t3.start();


    }
}
