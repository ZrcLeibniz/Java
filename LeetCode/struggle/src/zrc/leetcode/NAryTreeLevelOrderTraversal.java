package zrc.leetcode;

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 118 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.*/
class LevelNode {
    public int val;
    public List<LevelNode> children;

    public LevelNode() {
    }

    public LevelNode(int _val) {
        val = _val;
    }

    public LevelNode(int _val, List<LevelNode> _children) {
        val = _val;
        children = _children;
    }
}


class NAryTreeLevelOrderTraversalSolution {
    public List<List<Integer>> levelOrder(LevelNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<LevelNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                LevelNode node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
