package zrc.leetcode;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 775 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class FindFirstAndLastPositionOfElementInSortedArraySolution {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 1 && nums[0] == target) {
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int pre;
        int last;
        result[0] = -1;
        result[1] = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                pre = mid;
                last = mid;
                while (pre > 0 && nums[pre - 1] == target) {
                    pre--;
                }
                while (last < nums.length - 1 && nums[last + 1] == target) {
                    last++;
                }
                result[0] = pre;
                result[1] = last;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
