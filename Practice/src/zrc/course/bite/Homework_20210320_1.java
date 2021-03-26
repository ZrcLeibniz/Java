package zrc.course.bite;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Homework_20210320_1 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 非递归的先序遍历
    public List<Integer> preTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }

    // 非递归的中序遍历
    public List<Integer> inTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    // 非递归的后序遍历
    public List<Integer> postTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> reverse = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            reverse.push(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!reverse.isEmpty()) {
            result.add(reverse.pop());
        }
        return result;
    }

    // 先序的morris遍历
    public List<Integer> preMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    result.add(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                result.add(cur.val);
            }
            cur = cur.right;
        }
        return result;
    }

    // 中序的morris遍历
    public List<Integer> morrisIn(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    // 后序morris遍历
    public List<Integer> morrisPost(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    add(result, cur);
                }
            }
            cur = cur.right;
        }
        add(result, root);
        return result;
    }

    private void add(List<Integer> result, TreeNode node) {
        TreeNode cord = reverse(node);
        TreeNode temp = cord;
        while (temp.right != null) {
            result.add(temp.val);
            temp = temp.right;
        }
        reverse(cord);
    }

    private TreeNode reverse(TreeNode node) {
        TreeNode pre = null;
        TreeNode cur = node;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
