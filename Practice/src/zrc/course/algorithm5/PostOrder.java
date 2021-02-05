package zrc.course.algorithm5;

import java.util.Stack;

public class PostOrder {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void postOrderII(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<TreeNode> reverse = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            reverse.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!reverse.isEmpty()) {
            System.out.print(reverse.pop().val + " ");
        }
    }
}
