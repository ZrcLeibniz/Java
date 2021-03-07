package zrc.course.algorithm15;

import java.util.Arrays;

/*
给定一个数组和目标值，数组中的数代表一枚硬币，目标值代表金额，现需要返回能组成目标值的最少硬币数
 */
public class CoinNumber {
    // 请计算有多少种组成方法
    public int solutionElse(int[] coins, int aim) {
        return processElse(coins, 0, aim);
    }

    private int processElse(int[] coins, int index, int aim) {
        if (index == coins.length) {
            return aim == 0 ? 1 : 0;
        }
        return processElse(coins, index + 1, aim - coins[index]) + processElse(coins, index + 1, aim);
    }

    // 优化为记忆化搜索
    public int solutionElseII(int[] coins, int aim) {
        int[][] memory = new int[coins.length + 1][aim + 1];
        for (int[] intS : memory) {
            Arrays.fill(intS, -1);
        }
        return processElseII(coins, 0, aim, memory);
    }

    private int processElseII(int[] coins, int index, int aim, int[][] memory) {
        if (memory[index][aim] != -1) {
            return memory[index][aim];
        }
        if (index == coins.length) {
            memory[index][aim] = aim == 0 ? 1 : 0;
            return aim == 0 ? 1 : 0;
        } else {
            memory[index][aim] = processElseII(coins, index + 1, aim - coins[index], memory)
                    + processElseII(coins, index + 1, aim, memory);
        }
        return memory[index][aim];
    }

    // 请计算最少需要多少枚硬币
    public int solution(int[] coins, int aim) {
        return process(coins, 0, aim);
    }

    public int process(int[] coins, int index, int aim) {
        if (aim < 0 || index == coins.length) {
            return -1;
        }
        if (aim == 0) {
            return 0;
        }
        int choiceI = process(coins, index + 1, aim);
        int choiceNextII = process(coins, index + 1, aim - coins[index]);
        if (choiceI == -1 && choiceNextII == -1) {
            return -1;
        } else {
            if (choiceI == -1) {
                return 1 + choiceNextII;
            } else if (choiceNextII == -1) {
                return choiceI;
            } else {
                return Math.min(choiceI, choiceNextII + 1);
            }
        }
    }

    // 优化为记忆化搜索
    public int solutionII(int[] coins, int aim) {
        int[][] memory = new int[coins.length + 1][aim + 1];
        for (int[] intS : memory) {
            Arrays.fill(intS, -2);
        }
        return processII(coins, 0, aim, memory);
    }

    private int processII(int[] coins, int index, int aim, int[][] memory) {
        if (aim < 0) {
            return -1;
        }
        if (memory[index][aim] != -2) {
            return memory[index][aim];
        }
        if (index == coins.length) {
            memory[index][aim] = -1;
        }
        if (aim == 0) {
            memory[index][aim] = 0;
        }
        int choiceOne = processII(coins, index + 1, aim, memory);
        int choiceTwo = processII(coins, index + 1, aim - coins[index], memory);
        if (choiceOne == -1 && choiceTwo == -1) {
            memory[index][aim] = -1;
        } else {
            if (choiceOne == -1) {
                memory[index][aim] = choiceTwo + 1;
            } else if (choiceTwo == -1) {
                memory[index][aim] = choiceOne;
            } else {
                memory[index][aim] = Math.min(choiceOne, choiceTwo + 1);
            }
        }
        return memory[index][aim];
    }

    // 优化为动态规划
    public int solutionIII(int[] coins, int aim) {
        int[][] dp = new int[coins.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[coins.length][i] = -1;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < dp[i].length; j++) {
                int choiceOne = dp[i + 1][j];
                int choiceTwo = dp[i + 1][j - coins[i]];
                if (choiceOne == -1 && choiceTwo == -1) {
                    dp[i][j] = -1;
                } else {
                    if (choiceOne == -1) {
                        dp[i][j] = choiceTwo + 1;
                    } else if (choiceTwo == -1) {
                        dp[i][j] = choiceOne;
                    } else {
                        dp[i][j] = Math.min(choiceOne, choiceTwo + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }
}
