package zrc.leetcode;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 664 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PalindromePartitioningSolution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] string = s.toCharArray();
        for (int right = 0; right < string.length; right++) {
            for (int left = 0; left <= right; left++) {
                if (string[left] == string[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> path = new ArrayDeque<>();
        process(s, path, result, 0, dp);
        return result;
    }

    private  void process(String string, Deque<String> path, List<List<String>> result, int index, boolean[][] dp) {
        if (index == string.length()) {
            result.add(new ArrayList<String>(path));
        }
        for (int i = index; i < string.length(); i++) {
            if (dp[index][i]) {
                path.addLast(string.substring(index, i + 1));
                process(string, path, result, i + 1, dp);
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
