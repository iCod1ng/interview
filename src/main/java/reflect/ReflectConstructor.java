package reflect;

import java.lang.reflect.Constructor;

/**
 * @author yanyuchi
 * @date 2019-06-12 22:16
 */
@SuppressWarnings("unchecked")
public class ReflectConstructor {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class,String.class);
        System.out.println(constructor);

        System.out.println("-----");
        Object person = personClass.newInstance();
        System.out.println(person);


    }
}
