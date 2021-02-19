package zrc.course.algorithm6;

public class LowestPublicAncestor {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode solution(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        TreeNode left = solution(root.left, node1, node2);
        TreeNode right = solution(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
