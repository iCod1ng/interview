package linkedlist;

/**
 * @author yanyuchi
 * @date 2019-06-30 21:45
 */
public class LinkedTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = LinkedList.newEmptyList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        for (Integer value :linkedList) {
            System.out.println(value);
        }

        LinkedList<String> stringLinkedList = LinkedList.newEmptyList();
        stringLinkedList.add("a");
        stringLinkedList.add("b");
        stringLinkedList.add("c");
        for (String value :
                stringLinkedList) {
            System.out.println(value);

        }


    }
}
