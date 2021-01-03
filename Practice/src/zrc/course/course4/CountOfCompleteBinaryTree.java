package zrc.course.course4;

public class CountOfCompleteBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 求一个完全二叉树的总的节点个数（要求时间复杂度低于O(N)）
    public int countOfCompleteBinaryTree(TreeNode root) {
        return bs(root, 1, mostLevelTree(root, 1));
    }

    public int bs(TreeNode node, int l, int h) {
        if (l == h) {
            return 1;
        }
        if (mostLevelTree(node.right, l + 1) == h) {
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    public int mostLevelTree(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level--;
    }
}
