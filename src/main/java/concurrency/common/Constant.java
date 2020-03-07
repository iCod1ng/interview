package concurrency.common;

/**
 * @author yanyuchi
 * @date 2020-03-07 14:21
 */
public class Constant {

    public interface MULTI_QUEUE{
        int MAX = 10;
    }

    public interface HOOK{
         String LOCK_PATH = "";
         String LOCK_FILE = ".lock";
         String PERMISSIONS = "rw-------";
    }
}
