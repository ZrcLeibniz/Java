package zrc.leetcode;

//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 688 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 */
class InvertBinaryTreeNode {
    int val;
    InvertBinaryTreeNode left;
    InvertBinaryTreeNode right;

    InvertBinaryTreeNode(int x) {
        val = x;
    }
}

class InvertBinaryTreeSolution {
    public InvertBinaryTreeNode invertTree(InvertBinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            InvertBinaryTreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        } else if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
