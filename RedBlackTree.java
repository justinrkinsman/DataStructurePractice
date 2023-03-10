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
        checkColor(newNode);
    }

    public void checkColor(Node<K, V> node) {
        if (node == root) {
            return;
        }
        if (!node.black && !node.parent.black) {
            correctTree(node);
        }
        checkColor((node.parent));
    }

    public void correctTree(Node<K, V> node) {
        if (node.parent.isLeftChild) {
            // aunt is node.parent.parent.right
            if (node.parent.parent.right == null || node.parent.parent.right.black) {
                rotate(node);
                return;
            }
            if (node.parent.parent.right != null) {
                node.parent.parent.right.black = true;
            }
            node.parent.parent.black = false;
            node.parent.black = true;
            return;
        }
        // aunt is grandparent.left
        if (node.parent.parent.left == null || node.parent.parent.left.black) {
            rotate(node);
            return;
        }
        if (node.parent.parent.left != null) {
            node.parent.parent.left.black = true;
        }
        node.parent.parent.black = false;
        node.parent.black = true;
        return;
    }

    public void rotate(Node<K, V> node) {
        if (node.isLeftChild) {
            if (node.parent.isLeftChild) {
                rightRotate(node.parent.parent);
                node.black = false;
                node.parent.black = true;
                if (node.parent.right != null) {
                    node.parent.right.black = false;
                }
                return;
            }
            rightLeftRotate(node.parent.parent);
            node.black = true;
            node.right.black = false;
            node.left.black = false;
            return;
        }
    }

    public void leftRotate(Node<K, V> node) {
        Node<K, V> temp = node.right;
        node.right = temp.left;
        if (node.right != null) {
            node.right.parent = node;
            node.right.isLeftChild = false;
        }
        if (node.parent == null) {
            // we are the root node
            root = temp;
            temp.parent = null;
        } else {
            temp.parent = node.parent;
            if (node.isLeftChild) {
                temp.isLeftChild = true;
                temp.parent.left = temp;
            } else {
                temp.isLeftChild = false;
                temp.parent.right = temp;
            }
        }
        temp.left = node;
        node.isLeftChild = true;
        node.parent = temp;
    }

    /* rewrite leftRotate for right rotation */

    public void leftRightRotate(Node<K, V> node) {
        leftRotate(node.left);
        rightRotate(node);
    }

    // public void rightLeftRotate(Node<K,V> node) {}
    public int height() {
        if (root == null) {
            return 0;
        }
        return height(root) - 1;
    }

    public int height(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;
        if (leftHeight > rightHeight) {
            return leftHeight;
        }
        return rightHeight;
    }

    public int blackNodes(Node<K, V> node) {
        if (node == null) {
            return 1;
        }
        int rightBlackNodes = blackNodes(node.right);
        int leftBlackNodes = blackNodes(node.left);
        if (rightBlackNodes != leftBlackNodes) {
            // throw an error or fix the tree

        }
        if (node.black) {
            leftBlackNodes++;
        }
        return leftBlackNodes;
    }
}
