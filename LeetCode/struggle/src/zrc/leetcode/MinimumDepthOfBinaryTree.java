package zrc.leetcode;

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 405 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 */
class MinimumDepthOfBinarySolutionTreeNode {
    int val;
    MinimumDepthOfBinarySolutionTreeNode left;
    MinimumDepthOfBinarySolutionTreeNode right;

    MinimumDepthOfBinarySolutionTreeNode() {
    }

    MinimumDepthOfBinarySolutionTreeNode(int val) {
        this.val = val;
    }

    MinimumDepthOfBinarySolutionTreeNode(int val, MinimumDepthOfBinarySolutionTreeNode left, MinimumDepthOfBinarySolutionTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class MinimumDepthOfBinarySolution {
    public int minDepth(MinimumDepthOfBinarySolutionTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minValue = Integer.MAX_VALUE;
        if (root.left != null) {
            minValue = Math.min(minDepth2(root.left), minValue);
        }
        if (root.right != null) {
            minValue = Math.min(minDepth2(root.right), minValue);
        }
        return minValue + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
