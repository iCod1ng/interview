package concurrency.cp1.application;

/**
 * @author yanyuchi
 * @date 2020-02-24 18:02
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1; //不使用static了

    private final  static  int Max = 50;

    @Override
    public void run() {
        while (index<=Max){
            System.out.println(Thread.currentThread()+"号码是:"+(index++));
        }
    }
}
