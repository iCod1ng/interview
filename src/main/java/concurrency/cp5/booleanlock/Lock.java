package concurrency.cp5.booleanlock;

import org.apache.commons.io.TaggedIOException;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface Lock {

    //可被打断锁
    void lock() throws InterruptedException;
    //可设置超时，以及被打断锁
    void lock(long mills) throws InterruptedException,TimeoutException;
    //释放锁
    void unlock();
    //阻塞线程
    List<Thread> getBlockedThread();
}
