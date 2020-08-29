package zrc.offer;

import java.util.ArrayList;

/*
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class JZ24 {
    private ArrayList<ArrayList<Integer>> countPath = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return countPath;
        }
        path.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            countPath.add(new ArrayList<>(path));
        }
        if (target > root.val) {
            if (root.left != null) {
                FindPath(root.left, target - root.val);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                FindPath(root.right, target - root.val);
                path.remove(path.size() - 1);
            }
        }
        return countPath;
    }
}
