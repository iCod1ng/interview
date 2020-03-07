package concurrency.cp5.single;

import java.util.concurrent.TimeUnit;

/**
 * @author yanyuchi
 * @date 2020-03-02 21:58
 */
public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(()->
        {
            for (;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer").start();

        new Thread(()->{
            for (;;){
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }
}
