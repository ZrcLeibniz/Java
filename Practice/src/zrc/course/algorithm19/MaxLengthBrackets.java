package zrc.course.algorithm19;

// 求最长的有效括号长度
public class MaxLengthBrackets {
    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (str[i] == ')') {
                pre = dp[i - 1] - 1;
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
