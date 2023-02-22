public class TreeNode<E> {
    E data;
    TreeNode<E> left, right;

    public TreeNode(E obj) {
        this.data = obj;
        left = right = null;
    }
}
