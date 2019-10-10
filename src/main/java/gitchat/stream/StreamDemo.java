package gitchat.stream;

import reflect.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author yanyuchi
 * @date 2019-06-23 21:14
 */
public class StreamDemo {

    //public static List<String> list = Arrays.asList("1","2","3");

    /**
     * 禁止在 foreach 循环里进行元素的 remove/add 操作
     * @param flag
     * flag = 2  java.util.ConcurrentModificationException
     * 使用 Java 8 中提供的 filter 过滤
     */
    public static  void alibaba(String flag){
        List<String> list = generateList();
        for (String item:list){
            if(flag.equals(item)){
                list.remove(item);
            }
        }
        System.out.println(list);
    }

    private static List<Person> generatePersons(){
        List<Person> personList = new ArrayList<>();
        Person a = new Person();
        a.setName("BB");
        a.setAge("23");
        personList.add(a);
        Person b = new Person();
        b.setName("CC");
        b.setAge("22");
        personList.add(b);
        return personList;

    }

    private static  List<String> generateList(){
        List<String> list = new ArrayList<String>(){
            {
                add("1");
                add("2");
            }
        };

        return  list;
    }

    /**
     * filter 过滤
     */
    public static void streamAPI(){
        List<String> list = generateList();
        List<String> onlyOneList = list.stream().filter(item -> "1".equals(item)).collect(Collectors.toList());
        System.out.println(onlyOneList);
    }

    public static List<String> nameList(){
        List<Person> personList = generatePersons();
        List<String> nameList = personList.stream().map(Person::getName).collect(Collectors.toList());
        return nameList;
    }




    public static void main(String[] args) {
       //alibaba("1");

        streamAPI();

        //System.out.println(nameList());
    }



}
