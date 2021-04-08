package zrc.leetcode;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1364 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class HouseRobberSolution {
    public int rob(int[] nums) {
        return process(nums, 0);
    }

    private int process(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int choiceI = process(nums, index + 2) + nums[index];
        int choiceII = process(nums, index + 1);
        return Math.max(choiceI, choiceII);
    }

    public static int robII(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[dp.length - 1] = 0;
        for (int index = dp.length - 2; index >= 0; index--) {
            int choiceI = nums[index] + (index + 2 >= dp.length - 1 ? 0 : dp[index + 2]);
            int choiceII = index + 1 >= dp.length - 1 ? 0 : dp[index + 1];
            dp[index] = Math.max(choiceI, choiceII);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        int i = robII(arr);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
