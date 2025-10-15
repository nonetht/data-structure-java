package Tree;

/**
 * 今天自己写一个二叉搜索树，就当是回顾和学习LeetCode内容了。
 */
public class BST<T extends Comparable<T>> {
    private TreeNode root;
    private int size;

    // 二叉树应该具备添加新的节点的功能
    // 首先，要保证插入的数值的合理性，如果为null，则失败
    // 如果插入相同的数值，则代表插入失败；反之，则代表插入成功
    public void insert(T val) {
        if (val == null) {
            // 如何弹出错误消息：invalid value
            return;
        }
        add(root, val);
    }

    // insert函数的辅助函数
    // 类似于add函数，
    private TreeNode<T> add(TreeNode<T> node, T val) {
        if (node == null) {
            return new TreeNode<>(val);
        }

        int cmp = val.compareTo(node.val);
        if (cmp > 0) {
            // go right
            node.right = add(node.right, val);
        } else if (cmp < 0) {
            // go left
            node.left = add(node.left, val);
        } else {
            // do nothing
            return null;
        }
    }

    // 还应该具备查看对应元素是否存在的功能
    public boolean contains(T val) {
        return false;
    }

    // 具备查看BST节点数量的功能
    public int size() {
        return 0;
    }

    /**
     * 整个BST之中最为复杂的操作，需要分三种情况来讨论
     * @param val
     */
    public void remove(T val) {

    }


}
