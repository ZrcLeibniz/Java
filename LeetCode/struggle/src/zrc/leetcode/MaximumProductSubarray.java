package zrc.leetcode;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1026 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MaximumProductsSubarraySolution {
    public int maxProduct(int[] nums) {
        Info[] dp = new Info[nums.length];
        dp[0] = new Info(nums[0], nums[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
           int positive = Math.max(nums[i], Math.max(dp[i - 1].positive * nums[i], dp[i - 1].negative * nums[i]));
           int negative = Math.min(nums[i], Math.min(dp[i - 1].positive * nums[i], dp[i - 1].negative * nums[i]));
           dp[i] = new Info(positive, negative);
           max = Math.max(max, Math.max(dp[i].positive, dp[i].negative));
        }
        return max;
    }

    private static class Info {
        int positive;
        int negative;

        public Info(int positive, int negative) {
            this.positive = positive;
            this.negative = negative;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
