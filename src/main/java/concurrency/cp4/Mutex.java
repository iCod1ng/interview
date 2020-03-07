package concurrency.cp4;

import java.util.concurrent.TimeUnit;

/**
 * @author yanyuchi
 * @date 2020-03-01 18:19
 */
public class Mutex {

    private final static Object MUTEX = new Object();

    public void accessResource(){
        synchronized (MUTEX){
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for (int i = 0; i <5 ; i++) {
            new Thread(mutex::accessResource).start();
        }
    }
}
