package concurrency.cp4;

import org.junit.Test;

/**
 * @author yanyuchi
 * @date 2020-03-01 18:01
 */
public class SyncTest {

    @Test
    public void test(){
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread t1 = new Thread(task,"No.1");

        Thread t2 = new Thread(task,"No.2");

        Thread t3 = new Thread(task,"No.3");

        Thread t4 = new Thread(task,"N0.4");

        t1.start();

        t2.start();

        t3.start();

        t4.start();
    }
}
