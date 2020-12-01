package zrc.leetcode;

//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 176 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SquareOfASortedArraySolution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while (index >= 0) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                result[index--] = (int)Math.pow(nums[right--], 2);
            } else {
                result[index--] = (int)Math.pow(nums[left++], 2);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
