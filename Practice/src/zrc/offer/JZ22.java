package zrc.offer;

import java.util.ArrayList;

/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> printTree = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove(0);
            printTree.add(remove.val);
            if (remove.left != null) {
                queue.add(root.left);
            }
            if (remove.right != null) {
                queue.add(root.right);
            }
        }
        return printTree;
    }
}
