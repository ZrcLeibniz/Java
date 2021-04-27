package zrc.leetcode;

//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 298 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationSumIIISolution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        process(result, path, n, k, 1);
        return result;
    }

    private static void process(List<List<Integer>> result, Deque<Integer> path, int n, int k, int index) {
        if (path.size() == k || n <= 0) {
            if (path.size() == k && n == 0) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            path.addLast(i);
            process(result, path, n - i, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
