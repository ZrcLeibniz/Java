package zrc.course.course4;

import java.util.Stack;

public class BinaryTreeErgodic {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 二叉树的先序遍历(递归版本)
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 二叉树的中序遍历(递归版本)
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // 二叉树的后序遍历(递归版本)
    public void posOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.println(root.val);
    }

    // 二叉树的先序遍历(非递归版本)
    public void preOrderII(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        System.out.println();
    }

    // 二叉树的中序遍历(非递归版本)
    public void inOrderII(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    // 二叉树的后序遍历(非递归版本)
    public void posOrderII(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> reverse = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                reverse.push(root);
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
            }
            for (TreeNode treeNode : reverse) {
                System.out.print(treeNode.val + " ");
            }
        }
        System.out.println();
    }
}
