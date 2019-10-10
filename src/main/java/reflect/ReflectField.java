package reflect;

import java.lang.reflect.Field;

/**
 * @author yanyuchi
 * @date 2019-06-12 22:03
 */
public class ReflectField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("------");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField:declaredFields){
            System.out.println(declaredField);
        }
        System.out.println("------");
        Person person = new Person();
        Field age  = personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person,"23");
        System.out.println(person.getAge());
    }
}
