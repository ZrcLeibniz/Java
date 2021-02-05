package zrc.course.algorithm5;

import java.util.Stack;

public class MidOrder {
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

    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.val + " ");
        midOrder(root.right);
    }

    public void midOrderII(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            if (root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }
}
