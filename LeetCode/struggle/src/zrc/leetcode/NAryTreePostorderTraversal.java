package zrc.leetcode;

//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 110 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.*/
class NAryNode {
    public int val;
    public List<NAryNode> children;

    public NAryNode() {}

    public NAryNode(int _val) {
        val = _val;
    }

    public NAryNode(int _val, List<NAryNode> _children) {
        val = _val;
        children = _children;
    }
};


class NAryTreePosterTraversalSolution {
    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> postorder(NAryNode root) {
        if(root == null) {
            return result;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        result.add(root.val);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
