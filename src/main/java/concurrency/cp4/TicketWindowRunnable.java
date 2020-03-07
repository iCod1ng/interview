package concurrency.cp4;

/**
 * @author yanyuchi
 * @date 2020-02-24 18:02
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1; //不使用static了

    private final  static  int Max = 888;

    private final static Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX){
            while (index<=Max){
                System.out.println(Thread.currentThread()+"号码是:"+(index++));
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable syncTask = new TicketWindowRunnable();

        Thread t1 = new Thread(syncTask,"一号窗口");

        Thread t2 = new Thread(syncTask,"二号窗口");

        Thread t3 = new Thread(syncTask,"三号窗口");

        Thread t4 = new Thread(syncTask,"四号窗口");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
