package zrc.course.course4;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryIsComplete {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 判断一颗二叉树是否满足完全二叉树的要求
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            l = root.left;
            r = root.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
