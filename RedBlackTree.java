public class RedBlackTree<K, V> {
    Node<K, V> root;
    int size;

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right, parent;
        boolean isLeftChild, black;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = parent = null;
            black = false;
            isLeftChild = false;
        }
    }

    public void add(K key, V value) {
        Node<K, V> node = new Node<K, V>(key, value);
        if (root == null) {
            root = node;
            root.black = true;
            size++;
            return;
        }
        add(root, node);
        size++;
    }

    private void add(Node<K, V> parent, Node<K, V> newNode) {
        if (((Comparable<K>) newNode.key).compareTo(parent.key) > 0) {
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
            }
            add(parent.right, newNode);
        }
        if (parent.left == null) {
            parent.left = newNode;
            newNode.parent = parent;
            newNode.isLeftChild = true;
        }
        add(parent.left, newNode);
    }
}
