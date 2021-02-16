package zrc.course;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Course4 {

    // 在二叉树中找到一个节点的后继节点(在中序遍历中一个节点的后一个结点)
    /*
    如果一个节点有右子树，那么这个节点的后继节点一定是右子树上最左的节点
    如果一个节点没有右子树，那么这个节点的后继节点是某个节点
    以该节点作为左子树，目标节点是该子树的左孩子
     */
    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }

    public TreeNode findPosOrderTreeNode(TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getMostLeft(node.right);
        } else {
            TreeNode parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private TreeNode getMostLeft(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 在二叉树中找到一个节点的前驱结点
    public TreeNode findPreTreeNode(TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            return getMostRight(node.left);
        } else {
            TreeNode parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private TreeNode getMostRight(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}

class BinaryTreeBasic {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 二叉树的前序遍历
    public ArrayList<Integer> preOrderRecur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrderRecur(root, result);
        return result;
    }

    public void preOrderRecur(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrderRecur(root.left, result);
        preOrderRecur(root.right, result);
    }

    // 二叉树的中序遍历
    public ArrayList<Integer> inOrderRecur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRecur(root, result);
        return result;
    }

    public void inOrderRecur(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left, result);
        result.add(root.val);
        inOrderRecur(root.right, result);
    }

    // 二叉树的后序遍历
    public ArrayList<Integer> posOrderRecur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        posOrderRecur(root, result);
        return result;
    }

    public void posOrderRecur(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        posOrderRecur(root.left, result);
        posOrderRecur(root.right, result);
        result.add(root.val);
    }

    // 使用非递归的方式实现二叉树的先序遍历
    public void preOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                System.out.print(cur.val + " ");
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        System.out.println();
    }

    // 使用非递归的方式实现二叉树的中序遍历
    public void inOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.val + " ");
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    // 使用非递归的方式实现二叉树的后序遍历
    public void posOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> reverse = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                reverse.push(cur);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
            for (TreeNode treeNode : reverse) {
                System.out.print(treeNode.val + " ");
            }
        }
        System.out.println();
    }
}

// 二叉树的序列化与反序列化
class BinarySerialize {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }

    // 二叉树的前序序列化
    public String serialPreOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String result = root.val + "!";
        result += serialPreOrderBinaryTree(root.left);
        result += serialPreOrderBinaryTree(root.right);
        return result;
    }

    // 二叉树的前序反序列化
    public TreeNode reconPreOrderBinaryTree(String s) {
        String[] values = s.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = reconPreOrder(queue);
        root.right = reconPreOrder(queue);
        return root;
    }
}

class IsBalance {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 判断一个树是否是平衡二叉树
    private class ReturnData {
        boolean isBalance;
        int h;

        public ReturnData(boolean isBalance, int h) {
            this.isBalance = isBalance;
            this.h = h;
        }
    }

    public ReturnData isBalanceBinaryTree(TreeNode root) {
        if (root == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = isBalanceBinaryTree(root.left);
        if (!leftData.isBalance) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = isBalanceBinaryTree(root.right);
        if (!rightData.isBalance) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }

    public boolean isBalance(TreeNode root) {
        return isBalanceBinaryTree(root).isBalance;
    }
}

// 判断一棵二叉树是不是搜索二叉树
class isSearchBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSearchBinaryTree(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            int pre = Integer.MIN_VALUE;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (root.val < pre) {
                        return false;
                    }
                    pre = root.val;
                    root = root.right;
                }
            }
        }
        return true;
    }
}

// 判断一棵树是不是完全二叉树
/*
1.一个二叉树有右孩子没有左孩子不是完全二叉树
2.如果一个节点不是左右两个孩子都全，那么后面遇到的所有节点都必须是叶子节点
 */
class isCompleteBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}

// 求一个完全二叉树的节点个数（要求时间复杂度低于O(N)）
class CountOfCompleteBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int countOfCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return bs(root, 1, mostLeftLevel(root, 1));
    }

    private int bs(TreeNode root, int l, int h) {
        if (l == h) {
            return 1;
        }
        if (mostLeftLevel(root.right, l + 1) == h) {
            return (1 << (h - l)) + bs(root.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(root.left, l + 1, h);
        }
    }

    private int mostLeftLevel(TreeNode root, int level) {
        while (root != null) {
            level++;
            root = root.left;
        }
        return level - 1;
    }

}