package zrc.course.bite.tree;

// 求二叉树的最大深度
public class MaxDepth {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(solution(root.left), solution(root.right)) + 1;
    }
}
