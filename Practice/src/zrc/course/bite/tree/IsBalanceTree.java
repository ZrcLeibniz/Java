package zrc.course.bite.tree;

// 是不是平衡二叉树
public class IsBalanceTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private class Info{
        int height;
        boolean isBalance;

        public Info(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public boolean solution(TreeNode root) {
        return process(root).isBalance;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalance = leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        return new Info(height, isBalance);
    }
}
