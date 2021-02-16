package zrc.course;

import java.util.*;

public class Algorithm6 {

}

// 判断一棵树是否是搜索二叉树
class IsBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private static int preValue = Integer.MIN_VALUE;

    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftCheck = solution(root.left);
        if (!leftCheck) {
            return false;
        }
        if (preValue > root.val) {
            return false;
        } else {
            preValue = root.val;
        }
        return solution(root.right);
    }

    public boolean solutionII(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            int preValue = Integer.MIN_VALUE;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    TreeNode cur = stack.pop();
                    if (cur.val < preValue) {
                        return false;
                    } else {
                        preValue = cur.val;
                    }
                    cur = cur.right;
                }
            }
        }
        return true;
    }

    private class ReturnData {
        boolean isSearch;
        int min;
        int max;

        public ReturnData(boolean isSearch, int min, int max) {
            this.isSearch = isSearch;
            this.min = min;
            this.max = max;
        }
    }

    public boolean solutionIII(TreeNode root) {
        return process(root).isSearch;
    }

    public ReturnData process(TreeNode root) {
        if (root == null) {
            return null;
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int min = root.val;
        int max = root.val;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        boolean isSearch = true;
        if (leftData != null && (!leftData.isSearch || leftData.max >= root.val)) {
            isSearch = false;
        }
        if (rightData != null && (!rightData.isSearch || rightData.min <= root.val)) {
            isSearch = false;
        }
        return new ReturnData(isSearch, min, max);
    }
}

// 如果判断一颗二叉树是完全二叉树
class IsCompleteBinaryTree {
    // 将一个二叉树层序遍历
    // 1.如果遇到某一个节点，有右孩子没有左孩子，直接返回false
    // 2.在不违反(1)的条件下，当遇到了第一个左右节点不全的节点，那么其后续节点必须都是叶子节点
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = null;
        TreeNode right = null;
        boolean leaf = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            left = cur.left;
            right = cur.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
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

// 如何判断一棵树是否是满二叉树
class IsFullBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private class ReturnData {
        int nodes;
        int height;

        public ReturnData(int nodes, int height) {
            this.nodes = nodes;
            this.height = height;
        }
    }

    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        ReturnData info = process(root);
        return info.nodes == (1 << info.height) - 1;
    }

    public ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new ReturnData(nodes, height);
    }
}

// 如何判断一棵树是否是平衡二叉树
class IsBalanceBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private class ReturnData {
        int height;
        boolean isBalance;

        public ReturnData(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public boolean solution(TreeNode root) {
        return process(root).isBalance;
    }

    public ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, true);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalance = leftData.isBalance && rightData.isBalance && (Math.abs(leftData.height - rightData.height) < 2);
        return new ReturnData(height, isBalance);
    }
}

// 寻找两个节点(都属于某个二叉树)在二叉树中的最近公共祖先
class LowestPublicAncestor {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode solution(TreeNode root, TreeNode node1, TreeNode node2) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, root);
        process(root, map);
        HashSet<TreeNode> set1 = new HashSet<>();
        TreeNode cur = node1;
        while (cur != map.get(node1)) {
            set1.add(node1);
            cur = map.get(cur);
        }
        set1.add(root);
        cur = node2;
        while (cur != map.get(cur)) {
            if (set1.contains(cur)) {
                return cur;
            } else {
                cur = map.get(cur);
            }
        }
        return root;
    }

    public TreeNode solutionII(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        TreeNode left = solutionII(root.left, node1, node2);
        TreeNode right = solutionII(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private void process(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        map.put(root.left, root);
        map.put(root.right, root);
        process(root.left, map);
        process(root.right, map);
    }
}

class BinaryTreeStorage {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String serial(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String result = root.val + "!";
        result += serial(root.left);
        result += serial(root.right);
        return result;
    }

    public TreeNode reconTree(String serial) {
        String[] values = serial.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return process(queue);
    }

    public TreeNode process(Queue<String> queue) {
        String value = queue.poll();
        if (value == "#") {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = process(queue);
        root.right = process(queue);
        return root;
    }
}

// 假设有一张纸条，给定参数，根据参数将纸条折叠对应次数，打印纸条的折痕方向（凹或凸）
class FoldsPaper {
    public void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    public void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }
}
