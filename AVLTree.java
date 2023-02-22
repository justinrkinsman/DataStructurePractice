public class AVLTree<E> {
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
}
