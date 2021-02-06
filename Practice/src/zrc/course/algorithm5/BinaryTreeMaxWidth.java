package zrc.course.algorithm5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxWidth {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int getMaxWidthI(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            max = Integer.max(max, size);
        }
        return max;
    }

    public int getMaxWidthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        HashMap<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root, 1);
        Integer Level = 1;
        Integer curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            Integer curLevel = map.get(cur);
            if (curLevel == Level) {
                curLevelNodes++;
            } else {
                Level++;
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 1;
            }
            if (cur.left != null) {
                map.put(root.left, curLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                map.put(root.right, curLevel + 1);
                queue.add(cur.right);
            }
        }
        return max;
    }
}
