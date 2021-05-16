package zrc.everyday;

public class Question_20210516_1 {
    public static int solution(int[][] board) {
        int[][] dp = new int[6][6];
        dp[0][0] = board[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
