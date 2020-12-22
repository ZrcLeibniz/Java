package zrc.leetcode;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 451 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinaryTreePreOrderTraversalSolution {
    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(PreOrderTreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return result;
    }

    public List<Integer> preorderTraversalII(PreOrderTreeNode root) {
        ArrayList<Integer> resultII = new ArrayList<>();
        Stack<PreOrderTreeNode> stack = new Stack<>();
        if (root == null) {
            return resultII;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            PreOrderTreeNode node = stack.pop();
            resultII.add(node.val);
            if (root.right != null) {
                stack.push(node.right);
            }
            if (root.left != null) {
                stack.push(node.left);
            }
        }
        return resultII;
    }

    public ArrayList<Integer> preorderTraversalIII(PreOrderTreeNode root) {
        ArrayList<Integer> resultIII = new ArrayList<>();
        if (root == null) {
            return resultIII;
        }
        ArrayList<Integer> left = preorderTraversalIII(root.left);
        ArrayList<Integer> right = preorderTraversalIII(root.right);
        resultIII.add(root.val);
        resultIII.addAll(left);
        resultIII.addAll(right);
        return resultIII;
    }
}

class PreOrderTreeNode {
    int val;
    PreOrderTreeNode left;
    PreOrderTreeNode right;

    public PreOrderTreeNode(int val, PreOrderTreeNode left, PreOrderTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public PreOrderTreeNode(int val) {
        this.val = val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
