package zrc.course.bite.tree;

// 判断两颗树是不是同一棵树
public class IsSameTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean solution(TreeNode root1, TreeNode  root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return solution(root1.left, root2.left) && solution(root1.right, root2.right);
    }

}
