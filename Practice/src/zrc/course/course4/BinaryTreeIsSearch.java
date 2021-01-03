package zrc.course.course4;

import java.util.Stack;

public class BinaryTreeIsSearch {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBinarySearchTree(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            int pre = Integer.MIN_VALUE;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (pre > root.val) {
                        return false;
                    }
                    pre = root.val;
                    root = root.right;
                }
            }
        }
        return true;
    }
}
