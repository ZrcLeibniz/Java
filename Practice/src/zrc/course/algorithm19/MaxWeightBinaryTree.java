package zrc.course.algorithm19;

/*
二叉树每个结点都有一个int型的权值，给定一颗二叉树，要求计算从根节点到叶节点的所有路径中，权值和最大的值为多少
 */
public class MaxWeightBinaryTree {
    private static class TreeNode {
        int weight;
        TreeNode left;
        TreeNode right;
    }

    public int solution(TreeNode root) {
        return process(root);
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = process(root.left);
        int rightSum = process(root.right);
        return root.weight + Math.max(leftSum, rightSum);
    }
}
