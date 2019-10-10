package generic;

/**
 * @author yanyuchi
 * @date 2019-08-24 10:52
 */
public class Generic<T> implements IGeneric<T>{
    private T key;

    public Generic(T key){
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    @Override
    public T next() {
        return null;
    }
}
