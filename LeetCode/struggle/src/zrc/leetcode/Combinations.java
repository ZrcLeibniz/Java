package zrc.leetcode;

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
// 👍 446 👎 0


import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationsSolution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        Deque deque = new ArrayDeque();
        combine(n, k, 1, deque, result);
        return result;
    }

    private void combine(int n, int k, int begin, Deque<Integer> part, List<List<Integer>> result) {
        if (part.size() == k) {
            result.add(new ArrayList<Integer>(part));
            return;
        }

        for (int i = begin; i <= n; i++) {
            part.addLast(i);
            combine(n, k, i + 1, part, result);
            part.removeLast();
        }
    }

    private void combinePlus(int n, int k, int begin, Deque<Integer> part, List<List<Integer>> result) {
        if (part.size() == k) {
            result.add(new ArrayList<Integer>(part));
            return;
        }
        for (int i = begin; i <= n - (k - part.size()) + 1; i++) {
            part.addLast(i);
            combinePlus(n, k, i + 1, part, result);
            part.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
