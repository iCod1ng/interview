package linkedlist;

/**
 * @author yanyuchi
 * @date 2019-06-30 21:29
 */
@SuppressWarnings("unchecked")
public class Node<T> {

     private T value;

     private Node next;

     public Node(T value){
         this.value = value;
         this.next = null;
     }

     public T getValue(){return value;}

     public Node<T> getNext(){return next;}

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static <T> void printLinkedList(Node<T> head){
         while (head !=null){
             System.out.print(head.getValue());
             System.out.print(" ");
             head = head.getNext();
         }
        System.out.println();
    }
}
