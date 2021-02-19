package zrc.course.algorithm6;

public class IsBalanceBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private class ReturnData {
        int high;
        boolean isBalance;

        public ReturnData(int high, boolean isBalance) {
            this.high = high;
            this.isBalance = isBalance;
        }
    }

    // 判断一棵树是否是平衡二叉树
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBalance;
    }

    private ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, true);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int high = Math.max(leftData.high, rightData.high) + 1;
        boolean isBalance = leftData.isBalance && rightData.isBalance && Math.abs(leftData.high - rightData.high) > 2;
        return new ReturnData(high, isBalance);
    }
}
