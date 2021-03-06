package zrc.course;

public class Algorithm16 {
}

/*
游戏的获胜者
 */
class PointOfWin {
    public int solution(int[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        return Math.max(pre(points, 0, points.length - 1), post(points, 0, points.length - 1));
    }

    private int pre(int[] points, int begin, int end) {
        if (begin == end) {
            return points[begin];
        }
        return Math.max(points[begin] + post(points, begin + 1, end), points[end] + post(points, begin, end - 1));
    }

    private int post(int[] points, int begin, int end) {
        if (begin == end) {
            return 0;
        }
        return Math.min(pre(points, begin + 1, end), pre(points, begin, end - 1));
    }

    public int solutionII(int[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int[][] pre = new int[points.length][points.length];
        int[][] post = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            pre[i][i] = points[i];
        }
        int row = 0;
        int col = 1;
        while (col < points.length) {
            int i = row;
            int j = col;
            while (i < points.length && j < points.length) {
                pre[i][j] = Math.max(points[i] + post[i + 1][j], points[j] + post[i][j - 1]);
                post[i][j] = Math.min(pre[i + 1][j], pre[i][j - 1]);
                i++;
                j++;
            }
            col++;
        }
        return Math.max(pre[0][points.length - 1], post[0][points.length - 1]);
    }
}

/*
马走日
给定一个x*y的棋盘，马处于最左上方的位置，现目前马的终点的坐标(a, b)，且规定必须走k步，求共有多少种方式
 */
class HorseStep {
    public int solution(int limitX, int limitY, int x, int y, int step) {
        return process(limitX, limitY, x, y, step);
    }

    public int process(int limitX, int limitY, int x, int y, int step) {
        if (x < 0 || x >= limitX || y < 0 || y >= limitY) {
            return 0;
        }
        if (step == 0) {
            return (x == 0 && y == 0) ? 1 : 0;
        }
        return process(limitX, limitY, x - 1, y - 2, step - 1) +
                process(limitX, limitY, x + 1, y - 2, step - 1) +
                process(limitX, limitY, x - 1, y + 2, step - 1) +
                process(limitX, limitY, x + 1, y + 2, step - 1) +
                process(limitX, limitY, x - 2, y - 1, step - 1) +
                process(limitX, limitY, x - 2, y + 1, step - 1) +
                process(limitX, limitY, x + 2, y - 1, step - 1) +
                process(limitX, limitY, x + 2, y + 1, step - 1);
    }

    public int solutionII(int limitX, int limitY, int x, int y, int step) {
        if (x < 0 || x >= limitX || y < 0 || y >= limitY || step < 0) {
            return 0;
        }
        int[][][] dp = new int[limitX][limitY][step + 1];
        dp[0][0][0] = 1;
        for (int height = 1; height <= step; height++) {
            for (int row = 0; row < dp[height].length; row++) {
                for (int col = 0; col < dp[height][row].length; col++) {
                    dp[row][col][height] += getValue(dp, row - 1, col - 2, height - 1);
                    dp[row][col][height] += getValue(dp, row + 1, col + 2, height - 1);
                    dp[row][col][height] += getValue(dp, row - 1, col + 2, height - 1);
                    dp[row][col][height] += getValue(dp, row + 1, col - 2, height - 1);
                    dp[row][col][height] += getValue(dp, row - 2, col - 1, height - 1);
                    dp[row][col][height] += getValue(dp, row + 2, col + 1, height - 1);
                    dp[row][col][height] += getValue(dp, row - 2, col + 1, height - 1);
                    dp[row][col][height] += getValue(dp, row + 2, col - 1, height - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    private int getValue(int[][][] dp, int row, int col, int height) {
        if (row < 0 || row >= dp.length || col < 0 || col >= dp[0].length || height < 0) {
            return 0;
        }
        return dp[row][col][height];
    }
}

/*
荒野求生
    给定M*N的地图，bob出在(a, b)位置，并且bob必须走k步，请返回bob生存下来的概率
 */
class BobWantLive {
    public String solution(int N, int M, int i, int j, int k) {
        long all = (long) Math.pow(4, k);
        long live = process(N, M, i, j, k);
        return String.valueOf(live) + "/" + String.valueOf(all);
    }

    public long process(int N, int M, int row, int col, int rest) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        long live = 0;
        live += process(N, M, row - 1, col, rest - 1);
        live += process(N, M, row + 1, col, rest - 1);
        live += process(N, M, row, col - 1, rest - 1);
        live += process(N, M, row, col + 1, rest + 1);
        return live;
    }

    public String solutionII(int N, int M, int row, int col, int rest) {
        int all = (int) Math.pow(4, rest);
        int[][][] dp = new int[N][M][rest + 1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][1] = 1;
            }
        }
        for (int h = 1; h <= rest; h++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j][h] += getValue(dp, i - 1, j, h - 1);
                    dp[i][j][h] += getValue(dp, i + 1, j, h - 1);
                    dp[i][j][h] += getValue(dp, i, j + 1, h - 1);
                    dp[i][j][h] += getValue(dp, i, j - 1, h - 1);
                }
            }
        }
        int live = dp[row][col][rest];
        return String.valueOf(live) + "/" + String.valueOf(all);
    }

    private int getValue(int[][][] dp, int row, int col, int height) {
        if (row < 0 || row >= dp.length || col < 0 || col >= dp[0].length || height < 0) {
            return 0;
        }
        return dp[row][col][height];
    }
}

// 给定一个数组，数组中的每个元素代表一种面额的货币，每种有任意张
// 给定总金额，要求拼出aim元，请返回总方法数
class CoinWay {
    public int solution(int[] coins, int aim) {
        return process(coins, 0, aim);
    }

    public int process(int[] coins, int begin, int aim) {
        if (begin == coins.length) {
            return aim == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int num = 0; coins[begin] * num <= aim; num++) {
            ways += process(coins, begin + 1, aim - coins[begin] * num);
        }
        return ways;
    }
}