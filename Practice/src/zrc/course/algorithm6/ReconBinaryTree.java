package zrc.course.algorithm6;

import java.util.LinkedList;
import java.util.Queue;

public class ReconBinaryTree {
    private static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }
    }

    public TreeNode solution(String string) {
        Queue<String> queue = new LinkedList<>();
        for (char c : string.toCharArray()) {
            queue.add(String.valueOf(c));
        }
        return process(queue);
    }

    private TreeNode process(Queue<String> queue) {
        String poll = queue.poll();
        if ("#".equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(poll);
        root.left = process(queue);
        root.right  =process(queue);
        return root;
    }
}
