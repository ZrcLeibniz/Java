package zrc.leetcode.reback;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1087 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] flag = new boolean[nums.length];
        generate(result, nums, path, flag);
        return result;
    }

    private void generate(List<List<Integer>> result, int[] nums, Deque<Integer> path, boolean[] flag) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                path.addLast(nums[i]);
                flag[i] = true;
                generate(result, nums, path, flag);
                flag[i] = false;
                path.removeLast();
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
