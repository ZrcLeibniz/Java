package zrc.leetcode;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 656 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class HouseRobberIISolution {
    public static int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private static int rob(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }
        int choiceI = rob(nums, begin + 2, end) + nums[begin];
        int choiceII = rob(nums, begin + 1, end);
        return Math.max(choiceI, choiceII);
    }

    public static int robII(int[] nums) {
        int[] dpI = new int[nums.length];
        int[] dpII = new int[nums.length];
        dpI[dpI.length - 1] = 0;
        dpII[dpII.length - 1] = 0;
        for (int i = dpI.length - 2; i >= 0; i--) {
            int choiceIOfI = ((i + 2) >= dpI.length ? 0 : dpI[i + 2]) + nums[i];
            int choiceIIofI = (i + 1) >= dpI.length ? 0 : dpI[i + 1];
            dpI[i] = Math.max(choiceIOfI, choiceIIofI);
        }
        for (int i = dpII.length - 2; i >= 0; i--) {
            int choiceIOfII = ((i + 2) >= dpII.length ? 0 : dpII[i + 2]) + nums[i + 1];
            int choiceIIofII = (i + 1) >= dpII.length ? 0 : dpII[i + 1];
            dpII[i] = Math.max(choiceIOfII, choiceIIofII);
        }
        return Math.max(dpI[0], dpII[0]);
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int i = robII(arr);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
