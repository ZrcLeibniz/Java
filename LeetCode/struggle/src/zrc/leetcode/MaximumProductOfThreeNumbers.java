package zrc.leetcode;

//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 195 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumProductOfThreeNumbersSolution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int maxIndex = nums.length - 1;
        return Math.max((nums[0] * nums[1] * nums[maxIndex]), (nums[maxIndex] * nums[maxIndex - 1] * nums[maxIndex - 2]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
