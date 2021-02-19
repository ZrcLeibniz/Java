package zrc.course.algorithm6;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeStorage {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String serial(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String result = root.val + "!";
        result += serial(root.left);
        result += serial(root.right);
        return result;
    }

    public TreeNode reconTree(String serial) {
        String[] values = serial.split("!");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return process(queue);
    }

    private TreeNode process(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = process(queue);
        root.right = process(queue);
        return root;
    }
}
