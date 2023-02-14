
//import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListPractice<E> {
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    class IteratorHelper implements Iterator<E> {
        Node<E> index;

        public IteratorHelper() {
            index = head;
        }

        public boolean hasNext() {
            return (index != null);
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = index.data;
            index = index.next;
            return value;
        }
    }

    private Node<E> head;
    private int currentSize;
    private Node<E> tail;

    public LinkedListPractice() {
        head = null;
        currentSize = 0;
    }

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
        return;
    }

    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            addFirst(obj);
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

    public E removeLast() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return removeFirst();
        }
        Node<E> current = head, previous = null;
        while (current != tail) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    public E remove(E obj) {
        Node<E> current = head, previous = null;
        while (current != null) {
            if (((Comparable<E>) current.data).compareTo(obj) == 0) {
                if (current == head) {
                    return removeFirst();
                }
                if (current == tail) {
                    return removeLast();
                }
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (((Comparable<E>) current.data).compareTo(obj) == 0) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public E peekLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

}