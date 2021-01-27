package zrc.leetcode.reback;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 473 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationsSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k || k <= 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        generate(result, path, 0, n, k);
        return result;
    }

    private void generate(List<List<Integer>> result, Deque<Integer> path, int begin, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            generate(result, path, i + 1, n, k);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
