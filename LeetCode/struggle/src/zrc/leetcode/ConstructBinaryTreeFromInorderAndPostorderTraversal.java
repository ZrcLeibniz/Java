package zrc.leetcode;

//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 406 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

class ConstructBinaryTreeFromInorderAndPostorderTraversalSolution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length),
                        Arrays.copyOfRange(postorder, i, postorder.length - 1));
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i),
                        Arrays.copyOfRange(postorder, 0, i));
                break;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
