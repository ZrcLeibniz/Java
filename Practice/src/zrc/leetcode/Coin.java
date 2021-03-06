package zrc.leetcode;

public class Coin {
    public int solve(int value) {
        if (value == 0) {
            return 0;
        }
        int coinNumber = Integer.MAX_VALUE;
        if (value >= 2) {
            coinNumber = Math.min(solve(value - 2) + 1, coinNumber);
        }
        if (value >= 5) {
            coinNumber = Math.min(solve(value - 5) + 1, coinNumber);
        }
        if (value >= 7) {
            coinNumber = Math.min(solve(value - 7) + 1, coinNumber);
        }
        return coinNumber;
    }

    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        int n = coins.length;
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            f[amount] = -1;
        }
        return f[amount];
    }
}
