package zrc.leetcode;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LongestCommonPrefixSolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            while (index < result.length() && index < strs[i].length()) {
                if (result.charAt(index) != strs[i].charAt(index)) {
                    break;
                }
                index++;
            }
            if (result.equals("")) {
                return "";
            }
            result = result.substring(0, index);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
