package zrc.course.algorithm15;

import java.util.Arrays;

/*
有一个机器人目前的位置是cur，一共是1~N个位置，最终目标要达到E位置，我们一共需要走K步，求解有多少种方法
 */
public class Walk {
    // 暴力递归方法
    public int solution(int N, int E, int K, int cur) {
        return process(N, E, K, cur);
    }

    private int process(int N, int E, int K, int cur) {
        if (K == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 1) {
            return process(N, E, K - 1, cur + 1);
        }
        if (cur == N) {
            return process(N, E, K - 1, cur - 1);
        }
        return process(N, E, K - 1, cur - 1) + process(N, E, K - 1, cur + 1);
    }

    // 记忆化搜索方法
    public int solutionII(int N, int E, int K, int cur) {
        int[][] memory = new int[K + 1][N + 1];
        for (int[] intS : memory) {
            Arrays.fill(intS, -1);
        }
        return processII(N, E, K, cur, memory);
    }

    private int processII(int N, int E, int K, int cur, int[][] memory) {
        if (memory[K][cur] != -1) {
            return memory[K][cur];
        }
        if (K == 0) {
            memory[K][cur] = cur == E ? 1 : 0;
            return memory[K][cur];
        }
        if (cur == 1) {
            memory[K][cur] = processII(N, E, K - 1, 2, memory);
        } else if (cur == N) {
            memory[K][cur] = processII(N, E, K - 1, N - 1, memory);
        } else {
            memory[K][cur] = processII(N, E, K - 1, cur - 1, memory) + processII(N, E, K - 1, cur + 1, memory);
        }
        return memory[K][cur];
    }

    // 优化为动态规划
    public int solutionIII(int N, int E, int K, int cur) {
        int[][] dp = new int[K + 1][N + 1];
        dp[0][E] = 1;
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {
                if (col == 1) {
                    dp[row][col] = dp[row - 1][col + 1];
                } else if (col == N) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col + 1];
                }
            }
        }
        return dp[K][cur];
    }

    public static void main(String[] args) {
        Walk walk = new Walk();
        int solutionI = walk.solution(8, 5, 4, 2);
        int solutionII = walk.solutionII(8, 5, 4, 2);
        int solutionIII = walk.solutionIII(8, 5, 4, 2);
        System.out.println(solutionI == solutionII && solutionII == solutionIII);
    }
}
