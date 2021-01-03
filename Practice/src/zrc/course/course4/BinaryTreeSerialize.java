package zrc.course.course4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialize {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 二叉树的序列化
    public String preBinaryTreeSerialize (TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String result = root.val + "!";
        result += preBinaryTreeSerialize(root.left);
        result += preBinaryTreeSerialize(root.right);
        return result;
    }

    // 二叉树的反序列化
    public TreeNode reconBinaryTree(String s) {
        String[] values = s.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconBinaryTree(queue);
    }

    public TreeNode reconBinaryTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = reconBinaryTree(queue);
        root.right = reconBinaryTree(queue);
        return root;
    }
}
