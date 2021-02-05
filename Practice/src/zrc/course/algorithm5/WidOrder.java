package zrc.course.algorithm5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WidOrder {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<TreeNode>> widListNode(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
