package zrc.course.bite.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }
            if (poll.left != null) {
                queue.offer(left);
            }
            if (poll.right != null) {
                queue.offer(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
