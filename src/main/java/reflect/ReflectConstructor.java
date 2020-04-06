package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author yanyuchi
 * @date 2019-06-12 22:16
 */
@SuppressWarnings("unchecked")
public class ReflectConstructor {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class,String.class);
        System.out.println(constructor);

        System.out.println("-----");
        Object person = personClass.newInstance();

        //通过Constructor的newInstance可以使用有参构造新的对象
        Object person1 = constructor.newInstance("bb","88");
        System.out.println(person);
        System.out.println(person1);


    }
}
