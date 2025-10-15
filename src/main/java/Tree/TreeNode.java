package Tree;

/**
 * 定义了TreeNode，也就是树的节点的定义
 * @param <T>
 */
public class TreeNode<T extends Comparable<T>> {
    T val;
    TreeNode left;
    TreeNode right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
