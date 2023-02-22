public class TreeNode<E> {
    E data;
    TreeNode<E> left, right;

    public TreeNode(E obj) {
        this.data = obj;
        left = right = null;
    }

    public void add(E obj, TreeNode<E> node) {
        if (((Comparable<E>) obj).compareTo(node.data) > 0) /* if object is bigger than data, go to right */ {
            if (node.right == null) {
                node.right = new TreeNode<E>(obj);
                return;
            }
            return add(obj, node.right);
        }
        if (node.left == null) {
            node.left = new TreeNode<E>(obj);
            return;
        }
        return add(obj, node.left);
    }

    public void add(E obj) {
        if (root == null) {
            root = new TreeNode<E>(obj);
        } else {
            add(obj, root);
        }
        currentSize++;
    }

    public boolean contains(E obj) {
        return contains(obj, root);
    }

    private boolean contains(E obj, TreeNode<E> node) {
        if (node == null) {
            return false;
        }
        if (((Comparable<E>) obj).compareTo(node.data) == 0) {
            return true;
        }
        if (((Comparable<E>) obj).compareTo(node.data) > 0) {
            return contains(obj, node.right);
        }
        return contains(obj, node.left);
    }

    public TreeNode<E> leftRotate(TreeNode<E> node) {
        TreeNode<E> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        return tmp;
    }

    public TreeNode<E> rightRotate(TreeNode<E> node) {
        TreeNode<E> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        return tmp;
    }

    public TreeNode<E> rightLeftRotate(TreeNode<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public TreeNode<E> leftRightRotate(TreeNode<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
}
