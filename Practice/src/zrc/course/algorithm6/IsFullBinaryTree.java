package zrc.course.algorithm6;

public class IsFullBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private class ReturnData {
        int nodes;
        int high;

        public ReturnData(int nodes, int high) {
            this.nodes = nodes;
            this.high = high;
        }
    }

    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return ((1 << process(root).high) + 1) == process(root).nodes;
    }

    private ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int high = leftData.high > rightData.high ? leftData.high + 1 : rightData.high + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new ReturnData(high, nodes);
    }
}
