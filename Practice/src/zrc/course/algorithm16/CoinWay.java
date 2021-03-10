package zrc.course.algorithm16;

public class CoinWay {
    public int solution(int[] coins, int aim) {
        return process(coins, aim, 0);
    }

    public int process(int[] coins, int aim, int begin) {
        if (begin == coins.length) {
            return aim == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int num = 0; coins[begin] * num < aim; num++) {
            ways += process(coins, aim - num * coins[begin], begin + 1);
        }
        return ways;
    }

    public int dynamicProgramming(int[] coins, int aim) {
        int[][] dp = new int[coins.length + 1][aim + 1];
        dp[coins.length][0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                int ways = 0;
                for (int num = 0; coins[i] * num < aim; num++) {
                    ways += dp[i + 1][j - num * coins[i]];
                }
            }
        }
        return dp[0][aim];
    }

    public int dynamicProgrammingII(int[] coins, int aim) {
        int[][] dp = new int[coins.length + 1][aim + 1];
        dp[coins.length][0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += dp[i][aim - coins[i]];
            }
        }
        return dp[0][aim];
    }
}