package zrc.leetcode;

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 510 👎 0


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class LargeNumberSolution {
    public String largestNumber(int[] nums) {
        String[] table = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            table[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(table, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        if (table[table.length - 1].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int i = table.length - 1; i >= 0; i--) {
            result.append(table[i]);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
