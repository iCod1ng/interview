package concurrency.cp5.booleanlock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author yanyuchi
 * @date 2020-03-07 18:06
 */
public class Test {
    private final Lock lock = new BooleanLock();

    public void syncMethod(){
        try{
            lock.lock();
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread() + "get the lock");
            TimeUnit.SECONDS.sleep(randomInt);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        IntStream.range(0,10).mapToObj(i -> new Thread(t::syncMethod))
                .forEach(Thread::start);
    }
}
