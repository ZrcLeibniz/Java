package zrc.leetcode;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 769 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.List;

class OrderTreeNode {
    int val;
    OrderTreeNode left;
    OrderTreeNode right;

    OrderTreeNode() {
    }

    OrderTreeNode(int val) {
        this.val = val;
    }

    OrderTreeNode(int val, OrderTreeNode left, OrderTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeInorderTraversalSolution {
    ArrayList<Integer> treeNode = new ArrayList<>();

    public List<Integer> inorderTraversal(OrderTreeNode root) {
        if (root == null) {
            return treeNode;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        treeNode.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
