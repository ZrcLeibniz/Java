package zrc.course.bite;

public class Homework_20210320_2 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public String solution(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        process(result, root);
        result.deleteCharAt(0);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private void process(StringBuilder result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.append("(");
        result.append(root.val);
        process(result, root.left);
        if (root.left == null && root.right != null) {
            result.append("()");
        }
        process(result, root.right);
        result.append(")");
    }
}
