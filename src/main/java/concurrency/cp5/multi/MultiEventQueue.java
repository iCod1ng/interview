package concurrency.cp5.multi;

import com.google.common.collect.Lists;
import concurrency.common.Constant;

import java.util.LinkedList;
import java.util.List;

/**
 * 多线程间通信
 * @author yanyuchi
 * @date 2020-03-07 14:17
 */
public class MultiEventQueue {


    private final int max;

    static class  Event{

    }
    private final LinkedList<Event> eventQueue = Lists.newLinkedList();

    public MultiEventQueue(){
        this( Constant.MULTI_QUEUE.MAX);
    }

    public MultiEventQueue(int max){
        this.max = max;
    }

    /**
     * offer
     */
    public void offer(Event event){
        synchronized (eventQueue){
            //多线程间 使用while代替if(两个线程同时进入if后，会出现数据问题)
            while (eventQueue.size()>=max){
                System.out.println("The queue is full");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("add event to queue");
            eventQueue.addLast(event);
            //多线程间通信 使用notifyAll替代notify，唤醒的所有线程会对monitor竞争
            eventQueue.notifyAll();
        }
    }


    public void take(){
        synchronized (eventQueue){
            while (eventQueue.isEmpty()){
                System.out.println("The queue is empty");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            System.out.println("take event"+event);
            notifyAll();
        }
    }
}
