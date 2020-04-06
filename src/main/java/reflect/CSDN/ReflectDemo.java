package reflect.CSDN;

import reflect.Person;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yanyuchi
 * @date 2020-04-06 18:37
 */
public class ReflectDemo {

    /**
     * 通过Object类中的getClass()
     * @return Class对象
     */
    private Class getClassInsatanceWayOne(){
        Person p = new Person();
        return p.getClass();
    }

    /**
     * 通过Class的静态方法forName
     * @return Class对象
     * @throws ClassNotFoundException
     */
    private Class getClassInstanceWayTwo() throws ClassNotFoundException {
        return Class.forName("reflect.Person");
    }

    /**
     * 通过T.class获取（T是任意Java类型）
     * @return Class对象
     */
    private Class getClassInstanceWayThree(){
        return Person.class;
    }


    /**
     * 通过Class实例获取类的名字
     * @param clazz
     * @return 类名
     */
    private String getClassName(Class clazz){
        return clazz.getName();
    }

    /**
     * 比较两个类对象
     * @param clazz
     * @return true or false
     */
    private boolean isPersonClass(Class clazz){
        return clazz == Person.class;
    }

    /**
     * 通过Class的newInstance创建对象（调用无参数构造，若要通过有参构造创建使用Constructor的newInstance）
     * @param clazz
     * @return object
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private <T> T newInstance(Class clazz) throws IllegalAccessException, InstantiationException {
        return (T) clazz.newInstance();
    }


    /**
     * 在运行时使用反射分析对象
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void runtimeInstance() throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person("BB","88");
        Class c1 = p.getClass();
        Field f = c1.getDeclaredField("name");
        //设置可以访问私有域
        f.setAccessible(true);
        //获取name属性的值
        Object v = f.get(p);
        System.out.println(v);
        //设置name属性的值
        f.set(p,"CC");
        System.out.println(f.get(p));
    }

    /**
     * 扩充已填满的数组(运行时抛出类型转换错误)
     * @param a
     * @param newLength
     * @return
     */
    public static Object[] badCopy(Object[] a,int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newLength,0,Math.min(a.length,newLength));
        return newArray;
    }

    /**
     * 通过反射，结合反射包下的Array来实现已满数组的扩容为可行方案
     * @param a
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object a,int newLength){
        Class c1 = a.getClass();
        if(!c1.isArray()){
            return null;
        }
        Class componentType = c1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }

    public static void methodInvoke() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Person p = new Person("BB","88");
        Method m1 = p.getClass().getMethod("getName");
        String name = (String) m1.invoke(p);
    }



    public static void main(String[] args) throws Exception{
        Method sqrt = Math.class.getMethod("sqrt",double.class);
        printTable(1,10,10,sqrt);
    }

    public static void printTable(double from,double to,int n,Method f){
        System.out.println(f);
        double dx = (to-from)/(n-1);

        for(double x = from;x<=to;x+=dx){
            try {
                double y = (Double) f.invoke(null,x);
                System.out.printf("%10.4f | %10.4f%n",x,y);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



}
