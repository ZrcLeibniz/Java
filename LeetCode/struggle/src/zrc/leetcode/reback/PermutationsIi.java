package zrc.leetcode.reback;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 564 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class PermutationsIISolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
//        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] flag = new boolean[nums.length];
        generate(result, path, nums, flag);
        return result;
    }

    private void generate(List<List<Integer>> result, Deque<Integer> path, int[] nums, boolean[] flag) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
                flag[i] = true;
                generate(result, path, nums, flag);
                flag[i] = false;
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
