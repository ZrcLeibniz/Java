package zrc.course.course4;

public class FindBinaryTreeNode {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }

    // 寻找二叉树某一结点的后继节点
    public TreeNode findPreTreeNode(TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return findMostLeft(node.right);
        } else {
            TreeNode parent = node.parent;
            while (parent != null && parent.left == node) {
                node = node.parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private TreeNode findMostLeft(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 寻找二叉树某一结点的前驱结点
    public TreeNode findPosTreeNode(TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            return findMostRight(node.left);
        } else {
            TreeNode parent = node.parent;
            while (parent != null && parent.right == node) {
                node = node.parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private TreeNode findMostRight(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
