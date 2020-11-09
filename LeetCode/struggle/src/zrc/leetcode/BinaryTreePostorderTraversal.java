package zrc.leetcode;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 474 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreePostOrderTraversalSolution {
    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(PostOrderTreeNode root) {
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        if (root.right != null) {
            postorderTraversal(root.right);
        }
        result.add(root.val);
        return result;
    }
}

class PostOrderTreeNode {
    int val;
    PostOrderTreeNode left;
    PostOrderTreeNode right;

    public PostOrderTreeNode(int val, PostOrderTreeNode left, PostOrderTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public PostOrderTreeNode(int val) {
        this.val = val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
