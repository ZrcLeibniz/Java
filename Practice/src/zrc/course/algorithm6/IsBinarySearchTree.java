package zrc.course.algorithm6;

import java.util.Stack;

public class IsBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 判断一颗二叉树是否是二叉搜索树
    // 在中序遍历的过程中，如果有前一个结点的值大于后一个结点的值，那么说明这棵树不是一个二插搜索树
    // 所以需要在二叉树的中序遍历过程中加入判断的逻辑
    public boolean solutionI(TreeNode root) {
        if (root == null) {
            return true;
        }
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
                    cur = cur.right;
                }
            }
        }
        return true;
    }

    public boolean solutionII(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBinarySearch;
    }

    private ReturnData process(TreeNode root) {
        if (root == null) {
            return null;
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int min = root.val;
        int max = root.val;
        if (leftData != null) {
            min = Math.min(leftData.min, min);
            max = Math.max(leftData.max, max);
        }
        if (rightData != null) {
            min = Math.min(rightData.min, min);
            max = Math.max(rightData.max, max);
        }
        boolean isBinarySearch = true;
        if (leftData != null && (!leftData.isBinarySearch || leftData.max >= root.val)) {
            isBinarySearch = false;
        }
        if (rightData != null && (!rightData.isBinarySearch || rightData.min <= root.val)) {
            isBinarySearch = false;
        }
        return new ReturnData(max, min, isBinarySearch);
    }

    private class ReturnData {
        int max;
        int min;
        boolean isBinarySearch;

        public ReturnData(int max, int min, boolean isBinarySearch) {
            this.max = max;
            this.min = min;
            this.isBinarySearch = isBinarySearch;
        }
    }
}
