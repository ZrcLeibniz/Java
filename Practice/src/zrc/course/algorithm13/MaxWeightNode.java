package zrc.course.algorithm13;

public class MaxWeightNode {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private class Info {
        int maxDistance;
        int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public int solution(TreeNode root) {
        return process(root).maxDistance;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int weight = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(leftInfo.maxDistance, rightInfo.maxDistance);
        maxDistance = Math.max(weight, maxDistance);
        return new Info(weight, maxDistance);
    }
}
