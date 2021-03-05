package zrc.course;

import java.util.Arrays;

public class Algorithm15 {
}

/*
有一个机器人，一共是1~N个位置，最终目标要达到E位置，我们一共需要走K步，求解有多少种方法
 */
class Walk {
    // 一共是1~N这么多位置---固定参数
    // 最终目标是E---固定参数
    // 还剩rest步需要走
    // 当前在cur位置
    // 返回方法数
    public int walkWays(int N, int E, int rest, int cur) {
        return fI(N, E, rest, cur);
    }

    private int fI(int N, int E, int rest, int cur) {
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 1) {
            return fI(N, E, rest - 1, 2);
        }
        if (cur == N) {
            return fI(N, E, rest - 1, N - 1);
        }
        return fI(N, E, rest - 1, cur - 1) + fI(N, E, rest - 1, cur + 1);
    }

    // 优化为记忆化搜索
    public int walkWaysII(int N, int E, int rest, int cur) {
        int[][] dp = new int[rest + 1][N + 1];
        for (int[] intS : dp) {
            Arrays.fill(intS, -1);
        }
        return fII(N, E, rest, cur, dp);
    }

    private int fII(int N, int E, int rest, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
            return cur == E ? 1 : 0;
        }
        if (cur == 1) {
            dp[rest][cur] = fII(N, E, rest - 1, 2, dp);
        }
        if (cur == N) {
            dp[rest][cur] = fII(N, E, rest - 1, N - 1, dp);
        } else {
            dp[rest][cur] = fII(N, E, rest - 1, cur - 1, dp) + fII(N, E, rest - 1, cur + 1, dp);
        }
        return dp[rest][cur];
    }

    public int dpWay(int N, int E, int rest, int cur) {
        int[][] dp = new int[rest + 1][N + 1];
        dp[0][E] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[rest][cur];
    }
}

/*
给定一个数组和目标值，数组中的数代表一枚硬币，目标值代表金额，现需要返回能组成目标值的最少硬币数
 */
class CoinNumber {
    // 返回有多少种组成方法数
    public int CoinNumberMethod(int[] arr, int aim) {
        return f(arr, 0, 0, aim);
    }

    private int f(int[] arr, int index, int pre, int aim) {
        if (index == arr.length) {
            return pre == aim ? 1 : 0;
        }
        return f(arr, index + 1, pre, aim) + f(arr, index + 1, pre + arr[index], aim);
    }

    // 正解
    public int minCoinNumber(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int choiceOne = process(arr, index + 1, rest);
        int choiceTwoNext = process(arr, index + 1, rest - arr[index]);
        if (choiceOne == -1 && choiceTwoNext == -1) {
            return -1;
        } else {
            if (choiceOne == -1) {
                return 1 + choiceTwoNext;
            } else if (choiceTwoNext == -1) {
                return choiceOne;
            } else {
                return Math.min(choiceOne, 1 + choiceTwoNext);
            }
        }
    }

    // 优化为记忆化搜索
    public int minCoinNumberII(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int[] intS : dp) {
            Arrays.fill(intS, -2);
        }
        return processII(arr, 0, aim, dp);
    }

    private int processII(int[] arr, int index, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = -1;
        }
        if (rest == 0) {
            dp[index][rest] = 0;
        }
        int choiceOne = processII(arr, index + 1, rest, dp);
        int choiceTwoNext = processII(arr, index + 1, rest + 1, dp);
        if (choiceOne == -1 && choiceTwoNext == -1) {
            dp[index][rest] = -1;
        } else {
            if (choiceOne == -1) {
                dp[index][rest] = 1 + choiceTwoNext;
            } else if (choiceTwoNext == -1) {
                dp[index][rest] = choiceOne;
            } else {
                dp[index][rest] = Math.min(choiceOne, 1 + choiceTwoNext);
            }
        }
        return dp[index][rest];
    }

    // 优化为动态规划
    public int minCoinNumberIII(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int row = 0; row < dp.length; row++) {
            dp[row][0] = 0;
        }
        for (int col = 1; col < dp[0].length; col++) {
            dp[dp.length - 1][col] = -1;
        }
        for (int index = dp.length - 2; index >= 0; index--) {
            for (int rest = 1; rest < dp[index].length - 1; rest++) {
                int choiceOne = dp[index + 1][rest];
                int choiceTwoNext = rest - arr[index] < 0 ? -1 : dp[index + 1][rest - arr[index]];
                if (choiceOne == -1 && choiceTwoNext == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (choiceOne == -1) {
                        dp[index][rest] = 1 + choiceTwoNext;
                    } else if (choiceTwoNext == -1) {
                        dp[index][rest] = choiceOne;
                    } else {
                        dp[index][rest] = Math.min(choiceOne, 1 + choiceTwoNext);
                    }
                }
            }
        }
        return dp[0][aim];
    }
}