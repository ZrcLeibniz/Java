package zrc.leetcode;

//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 104 
// 0 <= t <= 231 - 1 
// 
// Related Topics 排序 Ordered Map 
// 👍 452 👎 0

import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class ContainsDuplicateIIISolution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long cur = (long) nums[i];
            Long left = treeSet.floor(cur);
            Long right = treeSet.ceiling(cur);
            if (left != null && cur - left <= t) {
                return true;
            }
            if (right != null && right - cur <= t) {
                return true;
            }
            treeSet.add((long)nums[i]);
            if (i >= k) {
                treeSet.remove((long)(nums[i - k]));
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
