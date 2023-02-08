//import java.util.List;

public class LinkedListPractice<E> /* implements List<E> */ {
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private int currentSize;
    // private Node<E> tail;

    public LinkedListPractice() {
        head = null;
        currentSize = 0;
    }

    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E obj) { // O(n)
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = node;
            currentSize++;
        }
        Node<E> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        currentSize++;
    }

    /*
     * ALT addLast O(1)
     * public void addLast(E obj) {
     * Node<E> node = new Node<E>(obj);
     * if (head == null) {
     * head = tail = node;
     * currentSize++;
     * return;
     * }
     * tail.next = node;
     * tail = node;
     * currentSize++;
     * return;
     * }
     * tail pointer needs to be added to addFirst() as well
     */

}
