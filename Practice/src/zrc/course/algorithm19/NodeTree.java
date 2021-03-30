package zrc.course.algorithm19;

/*
给定一个非负数，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
 */
public class NodeTree {
    public int solution(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        for (int left = 0; left <= n - 1; left++) {
            int leftWays = solution(left);
            int rightWays = solution(n - 1 - leftWays);
            result += leftWays * rightWays;
        }
        return result;
    }

    public int dp(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = 0;
            for (int left = 0; left <= n - 1; left++) {
                dp[i] += dp[left] * dp[i - left - 1];
            }
        }
        return dp[n];
    }
}
