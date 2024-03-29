package zrc.leetcode;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 828 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 */
class ValidateBinarySearchTreeSolution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidHelper(TreeNode root, Long lower, Long higher) {
        if (root == null) {
            return true;
        }
        if (root.val >= higher || root.val <= lower) {
            return false;
        }
        return isValidHelper(root.left, lower, (long) root.val) && isValidHelper(root.right, (long) root.val, higher);
    }

    static Long pre = Long.MIN_VALUE;

    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = (long) root.val;
        if (!isValidBST2(root.right)) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
