package zrc.course.bite.tree;

// 判断一棵树是不是另一棵树的子树
public class SubtreeOfAnotherTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean solution(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return check(s, t) || solution(s.left, t) || solution(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
