package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yanyuchi
 * @date 2019-06-30 21:28
 */
@SuppressWarnings("unchecked")
public class LinkedList<T> implements Iterable<T> {

    private  Node<T> head;

    private Node<T> tail;

    public static <T> LinkedList<T> newEmptyList(){
       return new  LinkedList<T>();
    }


    public LinkedList(){
        head = null;
        tail = null;
    }

    public void add(T  value){
        Node<T> node = new Node<>(value);
        if(tail == null){
            head = node;
        }else {
            tail.setNext(node);
        }
        tail = node;
    }


    private class ListIterator implements Iterator<T>{

        private Node<T> currentNode;

        public ListIterator(Node head){
            currentNode = head;
        }

        @Override
        public T next() {

            if(currentNode == null){
                throw  new NoSuchElementException();
            }
            T value = currentNode.getValue();
            currentNode = currentNode.getNext();

            return value;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }
}
