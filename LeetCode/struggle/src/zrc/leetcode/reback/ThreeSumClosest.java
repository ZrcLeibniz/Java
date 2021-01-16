package zrc.leetcode.reback;

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
// 👍 660 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumClosestSolution {
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(min)) {
                    min = sum - target;
                }
            }
        }
        return min + target;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, -5, 3, -4};
        int i = threeSumClosest(arr, -1);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
