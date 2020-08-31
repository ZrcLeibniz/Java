package zrc.offer;


import java.util.ArrayList;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class JZ26 {
    private ArrayList<TreeNode> treeNodeList = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        preErgodic(pRootOfTree);
        for (int i = 0; i < treeNodeList.size(); i++) {
            treeNodeList.get(i).left = null;
            treeNodeList.get(i).right = null;
        }
        for (int i = 0; i < treeNodeList.size(); i++) {
            treeNodeList.get(i).right = i + 1 > treeNodeList.size() - 1 ? null : treeNodeList.get(i + 1);
        }
        for (int i = treeNodeList.size() - 1; i >= 0; i--) {
            treeNodeList.get(i).left = i - 1 < 0 ? null : treeNodeList.get(i - 1);
        }
        return treeNodeList.get(0);
    }

    private void preErgodic(TreeNode pRootOfTree) {
        TreeNode temp = pRootOfTree;
        if (temp.left != null) {
            preErgodic(temp.left);
        }
        treeNodeList.add(temp);
        if (temp.right != null) {
            preErgodic(temp.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        JZ26 jz26 = new JZ26();
        TreeNode convert = jz26.Convert(node1);
        System.out.println(convert.right.val);
        System.out.println(convert.right.left.val);
    }
}
