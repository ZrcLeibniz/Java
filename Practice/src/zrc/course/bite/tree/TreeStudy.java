package zrc.course.bite.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeStudy {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> recursionPreErgodic(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preProcess(result, root);
        return result;
    }

    private void preProcess(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preProcess(result, root.left);
        preProcess(result, root.right);
    }

    public List<Integer> recursionMidErgodic(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        midProcess(result, root);
        return result;
    }

    private void midProcess(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        midProcess(result, root.left);
        result.add(root.val);
        midProcess(result, root.right);
    }

    public List<Integer> recursionPostErgodic(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postProcess(result, root);
        return result;
    }

    private void postProcess(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        postProcess(result, root.left);
        postProcess(result, root.right);
        result.add(root.val);
    }

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return leftSize + rightSize + 1;
    }

    public List<Integer> preErgodic(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public List<Integer> postErgodic(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> reverse = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            reverse.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!reverse.isEmpty()) {
            result.add(reverse.pop().val);
        }
        return result;
    }

    public List<Integer> midErgodic(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    public int leafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftSize = leafSize(root.left);
        int rightSize = leafSize(root.right);
        return leftSize + rightSize;
    }

    public int KNum(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int leftNum = KNum(root.left, k - 1);
        int rightNum = KNum(root.left, k - 1);
        return leftNum + rightNum;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode find(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        TreeNode result = find(root.left, target);
        if (result == null) {
            return find(root.right, target);
        }
        return result;
    }

    public void MorrisTravel(TreeNode root) {
        if (root == null) {
            return;
        }
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
            cur = cur.right;
        }
    }

    public List<Integer> preMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    result.add(cur.val);
                    mostRight.right = cur;
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

    public List<Integer> midMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
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

    public List<Integer> postMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
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
                    printEdge(cur, result);
                }
            }
            cur = cur.right;
        }
        printEdge(root, result);
        return result;
    }

    private void printEdge(TreeNode node, List<Integer> result) {
        TreeNode reverse = reverse(node);
        TreeNode cord = reverse;
        while (reverse != null) {
            result.add(reverse.val);
            reverse = reverse.right;
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