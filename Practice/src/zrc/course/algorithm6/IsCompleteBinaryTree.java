package zrc.course.algorithm6;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 判断一棵树是否是完全二叉树
    // 1.当出现一个结点有右结点而没有左结点时，这棵树不是完全二叉树
    // 2.在满足第一条的情况下，当遇到第一个左右孩子不全的结点后，之后所有的结点都必须是叶子节点
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if ((leaf && (cur.left != null || cur.right != null)) || cur.left == null && cur.right != null) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
