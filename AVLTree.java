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
        if ((((Comparable<E>) newNode.data).compareTo(parent.data) > 0)) {
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                currentSize++;
            } else {
                add(parent.right, newNode);
            }
        } else {
            if (parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                currentSize++;
            } else {
                add(parent.left, newNode);
            }
        }
        checkBalance(newNode);
    }

    public void checkBalance(Node<E> node) {
        if ((height(node.left) - height(node.right) > 1) || (height(node.left) - height(node.right) < -1)) {
            rebalance(node);
        }
        if (node.parent == null) {
            return;
        }
        checkBalance(node.parent);
    }

    public void rebalance(Node<E> node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rightRotate(node);
            } else {
                node = leftRightRotate(node);
            }
        } else {
            if (height(node.right.left) - height(node.left.right)) {
                node = leftRotate(node);
            } else {
                node = rightLeftRotate(node);
            }
        }
        if (node.parent == null) {
            root = node;
        }
    }
}
