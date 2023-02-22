public class AVLTree<E> {
    Node<E> root;
    int currentSize;

    class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T obj) {
            data = obj;
            left = right = parent = null;
        }
    }

    public AVLTree() {
        root = null;
        currentSize = 0;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj);
        if (root == null) {
            root = node;
            currentSize++;
            return;
        }
        add(root, node);
    }

    public void add(Node<E> parent, Node<E> newNode) {

    }
}
