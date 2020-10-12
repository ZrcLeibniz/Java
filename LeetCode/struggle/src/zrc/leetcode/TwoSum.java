package zrc.leetcode;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9340 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

// 对数组排序，之后定义两个指针分别指向最小的元素和最大的元素，如果两个之和小于target将指针右移动，反之亦反
class TwoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] temp = new int[nums.length];
        int r0 = 0;
        int r1 = 0;
        int i = 0;
        int j = 0;
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r0 = nums[l];
                r1 = nums[r];
                break;
            }
        }
        for (; i < nums.length; i++) {
            if (temp[i] == r0) {
                result[0] = i;
                break;
            }
        }
        for (; j < nums.length; j++) {
            if (temp[j] == r1 && i != j) {
                result[1] = j;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
