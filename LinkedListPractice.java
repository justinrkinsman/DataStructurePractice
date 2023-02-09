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
    private Node<E> tail;

    public LinkedListPractice() {
        head = null;
        currentSize = 0;
    }

    // add tail to list if list is empty or if list only has one element
    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = tail = node;
            currentSize++;
            return;
        }
        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
        return;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E tmp = head.data;
        if (head.next == null) {
            // if (currentSize == 1)
            head = tail = null;
        } else {
            head = head.next;
        }
        currentSize--;
        return tmp;
    }

}

// add tail pointer to addFirst()