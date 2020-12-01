package zrc.leetcode;

//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 218 👎 0


import java.util.ArrayList;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class ContainDuplicateIISolution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        //ArrayList<Integer> hashSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
            if (hashSet.size() > k) {
                hashSet.remove(nums[k - i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        boolean b = containsNearbyDuplicate(nums, 2);
        System.out.println(b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
