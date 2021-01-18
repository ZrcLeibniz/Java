package zrc.leetcode.reback;

//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 672 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class ImplementStrSolution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int nHaystack = haystack.length();
        int nNeedle = needle.length();
        int index = 1;
        for (int i = 0; i < nHaystack - nNeedle + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = i + 1; j < nHaystack && index < nNeedle; j++) {
                    if (haystack.charAt(j) == needle.charAt(index)) {
                        index++;
                    } else {
                        index = 1;
                        break;
                    }
                }
                if (index == nNeedle) {
                    return i;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
