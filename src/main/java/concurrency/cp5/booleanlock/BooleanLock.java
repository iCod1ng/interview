package concurrency.cp5.booleanlock;

import org.apache.commons.io.TaggedIOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * @author yanyuchi
 * @date 2020-03-07 14:55
 */
public class BooleanLock implements Lock {

    //持有锁的线程
    private Thread currentThread;

    //锁是否被拥有
    private boolean locked = false;

    //被阻塞的线程
    private final List<Thread> blocledList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this){
            while (locked){
                if(!blocledList.contains(Thread.currentThread()))
                    blocledList.add(Thread.currentThread());
                this.wait();
            }
            blocledList.remove(Thread.currentThread());
            this.locked = true;
            this.currentThread = Thread.currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this){
            if(mills<=0){
                this.lock();
            }else {
                long remainingMills = mills;
                long endMills = System.currentTimeMillis() + remainingMills;
                while (locked){
                    if(remainingMills <= 0){
                        throw new TimeoutException("can not get the lock during "+ mills +"ms");
                    }
                    if(!blocledList.contains(Thread.currentThread())){
                        blocledList.add(Thread.currentThread());
                    }
                    this.wait(remainingMills);
                    remainingMills = endMills - System.currentTimeMillis();
                }

                blocledList.remove(Thread.currentThread());
                this.locked = true;
                this.currentThread = Thread.currentThread();
            }
        }

    }

    @Override
    public void unlock() {
        synchronized (this){
            if(currentThread == Thread.currentThread()){
                this.locked = false;
                Optional.of(Thread.currentThread().getName() + " release this lock.").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThread() {
        return Collections.unmodifiableList(blocledList);
    }
}
