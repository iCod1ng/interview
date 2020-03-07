package concurrency.cp5.single;


import java.util.LinkedList;
import java.util.List;

/**
 * @author yanyuchi
 * @date 2020-03-02 21:41
 */
public class EventQueue {

    private final int max;

    static class Event{

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static  int DEFAULT_MAX_EVENT = 10;

    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max){
        this.max = max;
    }
    private void console(String message){
        System.out.printf("%s:%s\n",Thread.currentThread().getName(),message);
    }

    public void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size() >=max){
                try{
                    console("the queue is full.");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            console("the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public void take(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try{
                    console("the queue is empty");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console("the event "+event+"is handled.");
        }
    }
}
