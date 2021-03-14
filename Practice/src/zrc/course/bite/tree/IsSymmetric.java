package zrc.course.bite.tree;

// 求一颗二叉树是不是镜像对称
public class IsSymmetric {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, root);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return check(root1.left, root2.right) && check(root1.right, root2.left);
    }
}
