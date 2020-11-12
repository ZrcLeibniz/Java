package zrc.leetcode;

//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class NAryPreNode {
    public int val;
    public List<NAryPreNode> children;

    public NAryPreNode() {}

    public NAryPreNode(int _val) {
        val = _val;
    }

    public NAryPreNode(int _val, List<NAryPreNode> _children) {
        val = _val;
        children = _children;
    }
};


class NAryTreePreorderTraversalSolution {
    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> preorder(NAryPreNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
