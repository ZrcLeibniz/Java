package zrc.leetcode;

//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 403 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SubsetsIISolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Deque path = new LinkedList();
        Arrays.sort(nums);
        process(nums, 0, result, path);
        return new ArrayList<>(result);
    }

    private void process(int[] nums, int index, Set<List<Integer>> result, Deque<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        path.addLast(nums[index]);
        process(nums, index + 1, result, path);
        path.removeLast();
        process(nums, index + 1, result, path);
    }

    public static void main(String[] args) {
        SubsetsIISolution subsetsIISolution = new SubsetsIISolution();
        List<List<Integer>> lists = subsetsIISolution.subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
