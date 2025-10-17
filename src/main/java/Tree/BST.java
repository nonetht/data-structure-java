package Tree;

/**
 * 今天自己写一个二叉搜索树，就当是回顾和学习LeetCode内容了。
 */
public class BST<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    // 二叉树应该具备添加新的节点的功能
    // 首先，要保证插入的数值的合理性，如果为null，则失败
    // 如果插入相同的数值，则代表插入失败；反之，则代表插入成功
    public void insert(T val) {
        if (val == null) {
            throw new IllegalArgumentException("Cannot insert null into BST");
        }
        root = add(root, val);
    }

    // insert函数的辅助函数
    // 我不明白，就是为什么要返回的类型设置为TreeNode呢？
    // 问题在于就是如果返回类型设置为void，那么第一行判断语句就无法生效
    private TreeNode<T> add(TreeNode<T> node, T val) {
        if (node == null) {
            size++; // 在这里执行size的递增操作
            return new TreeNode<>(val);
        }

        int cmp = val.compareTo(node.val);
        if (cmp > 0) {
            // go right
            node.right = add(node.right, val);
        } else {
            // go left
            node.left = add(node.left, val);
        }
        // 最后应该返回什么?
        return node;
    }

    // 还应该具备查看对应元素是否存在的功能
    public boolean contains(T val) {
        if (val == null) {
            return false;
        }
        return find(root, val);
    }

    // 仍旧是应该使用递归来完成寻找对应元素的功能
    private boolean find(TreeNode<T> node, T val) {
        if (node == null) {
            return false;
        }

        int cmp = val.compareTo(node.val);
        if (cmp > 0) {
            return find(node.right, val);
        } else if (cmp < 0) {
            return find(node.left, val);
        } else {
            return true;
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    // 具备查看BST节点数量的功能
    public int size() {
        return size;
    }

    /**
     * 一直向左走，就可以找到最小值
     * @return
     */
    public T findMin() {
        if (root == null) {
            return null;
        }
        return findMin(root);
    }

    private T findMin(TreeNode<T> node) {
        if (node.left == null) {
            return node.val;
        }
        return findMin(node.left);
    }

    /**
     * 一直向右走，就可以找到最大值
     * @return
     */
    public T findMax() {
        if (root == null) {
            return null;
        }
        return findMax(root);
    }

    private T findMax(TreeNode<T> node) {
        if (node.right == null) {
            return node.val;
        }
        return findMax(node.right);
    }

    /**
     * 整个BST之中最为复杂的操作，需要分三种情况来讨论
     * case1: 当待删除节点为leaf node的时候，直接删除即可
     * case2: 当待删除节点有**一个**子节点时，
     * case3: 当待删除节点有**两个**子节点时，
     * @param val
     */
    public void remove(T val) {
        if (val == null) {
            throw new IllegalArgumentException("Cannot remove null from BST");
        }
        delete(root, val);
    }

    // 还有一点就是，关于size大小变化在哪里变化呢？
    // 对于delete函数而言，应该在确定要删除一个节点时执行!
    private TreeNode<T> delete(TreeNode<T> node, T val) {
        // 说明没有找到对应的节点
        if (node == null) {
            return null;
        }

        int cmp = val.compareTo(node.val);

        if (cmp > 0) {
            node.right = delete(node.right, val);
        } else if (cmp < 0) {
            node.left = delete(node.left, val);
        } else {
            if (node.left == null && node.right == null) {
                // case1: 待删除节点为leaf node的时候
                size--;
                return null;
            } else if (node.left != null && node.right != null) {
                // case3: 待删除节点有两个子节点时
                // 对于当前节点而言，将左子树最大值替换上来，或者是将右子树的最小值替换上来
                // step1. 将值进行替换
                // step2. 随后将左子树最大值/右子树最小值进行一个移除操作
                node.val = findMin(node.right); // 将值替换为右子树最小值
                node.right = removeMin(node.right); // 移除右子树的最小值
                return node;
            } else {
                // case2: 有一个子节点时
                if (node.left != null) {
                    size--;
                    return node.left;
                } else {
                    size--;
                    return node.right;
                }
            }
        }
        return node;
    }

    // 移除最小值
    private TreeNode<T> removeMin(TreeNode<T> node) {
        if (node.left == null) {
            // 关键是，如果右节点不为空呢？就相当于删除一个只有一个子节点的节点
            TreeNode<T> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
