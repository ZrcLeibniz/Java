package zrc.leetcode;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2962 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromicSubStringSolution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int maxLength = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLength && validPalindromic(charArray, i, j)) {
                    begin = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    private boolean validPalindromic(char[] s, int left, int right) {
        while (left < right) {
            if (!(s[left] == s[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindromeII(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLength = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int oddLen = validPalindromicII(charArray, i, i);
            int evenLen = validPalindromicII(charArray, i, i + 1);
            int curMax = Math.max(oddLen, evenLen);
            if (curMax > maxLength) {
                maxLength = curMax;
                begin = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(begin, maxLength);
    }

    private static int validPalindromicII(char[] s, int left, int right) {
        int len = s.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s[i] == s[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = longestPalindromeII(s);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
