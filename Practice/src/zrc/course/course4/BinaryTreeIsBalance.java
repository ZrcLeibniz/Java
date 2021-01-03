package zrc.course.course4;

public class BinaryTreeIsBalance {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 判断一颗树是不是平衡二叉树
    class ReturnData {
        boolean isBalance;
        int h;

        public ReturnData(boolean isBalance, int h) {
            this.isBalance = isBalance;
            this.h = h;
        }
    }

    public ReturnData isBalance(TreeNode root) {
        if (root == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = isBalance(root.left);
        if (!leftData.isBalance) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = isBalance(root.right);
        if (!rightData.isBalance) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }
}
