package zrc.leetcode;

//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 615 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MinimumSizeSubarraySumSolution {
    public static int minSubArrayLen(int target, int[] nums) {
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        for (int i = 1; i < maxSum.length; i++) {
            maxSum[i] = maxSum[i - 1] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxSum[i] < target) {
                continue;
            }
            int cur = maxSum[i];
            min = Math.min(min, i + 1);
            for (int j = 0; j < i; j++) {
                if (cur - nums[j] < target) {
                    break;
                } else {
                    cur = cur - nums[j];
                    min = Math.min(min, i - j);
                }
            }
        }
        return min;
    }

    public static int minSubArrayLenII(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(end - start + 1, min);
                sum -= nums[start++];
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int i = minSubArrayLen(target, arr);
        System.out.println(i);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
