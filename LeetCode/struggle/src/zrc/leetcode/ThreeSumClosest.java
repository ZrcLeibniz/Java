package zrc.leetcode;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 637 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumClosestSolution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int cur = nums[left] + nums[right] + nums[i];
                if (right > 0 && cur > target) {
                    right--;
                } else if (left < nums.length && cur < target) {
                   left++;
                } else {
                    return cur;
                }
                if (Math.abs(cur - target) < Math.abs(min)) {
                    min = cur - target;
                }
            }
        }
        return min + target;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int i = threeSumClosest(nums, 1);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
