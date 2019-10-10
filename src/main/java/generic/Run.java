package generic;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

/**
 * @author yanyuchi
 * @date 2019-08-24 11:05
 */
public class Run {
    public static void main(String[] args) {

        Generic<Integer> generic = new Generic(123);

        Integer  a  = generic.getKey();
        System.out.println(a);


        Generic generic1 = new Generic("str");

    }

    public static void show(Generic<?> key){
        System.out.println(key.getKey());
    }
}
