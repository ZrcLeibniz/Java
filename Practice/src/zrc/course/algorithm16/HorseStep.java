package zrc.course.algorithm16;

public class HorseStep {
    public int solution(int limitX, int limitY, int step, int x, int y) {
        return process(limitX, limitY, step, x, y);
    }

    private int process(int limitX, int limitY, int step, int x, int y) {
        if (x >= limitX || x < 0 || y >= limitY || y < 0) {
            return 0;
        }
        if (step == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        return process(limitX, limitY, step - 1, x + 1, y + 2)
                + process(limitX, limitY, step - 1, x + 1, y - 2)
                + process(limitX, limitY, step - 1, x - 1, y + 2)
                + process(limitX, limitY, step - 1, x - 1, y - 2)
                + process(limitX, limitY, step - 1, x + 2, y + 1)
                + process(limitX, limitY, step - 1, x + 2, y - 1)
                + process(limitX, limitY, step - 1, x - 2, y + 1)
                + process(limitX, limitY, step - 1, x - 2, y - 1);
    }

    public int dynamicProgramming(int limitX, int limitY, int x, int y, int step) {
        if (x < 0 || x >= limitY || y < 0 || y >= limitY || step < 0) {
            return 0;
        }
        int[][][] dp = new int[limitX][limitY][step + 1];
        dp[0][0][0] = 1;
        for (int height = 1; height <= step; height++) {
            for (int row = 0; row < limitX; row++) {
                for (int col = 0; col < limitY; col++) {
                    dp[height][row][col] += getValue(dp, x + 1, y + 2, height - 1);
                    dp[height][row][col] += getValue(dp, x + 1, y - 2, height - 1);
                    dp[height][row][col] += getValue(dp, x - 1, y + 2, height - 1);
                    dp[height][row][col] += getValue(dp, x - 1, y - 2, height - 1);
                    dp[height][row][col] += getValue(dp, x + 2, y + 1, height - 1);
                    dp[height][row][col] += getValue(dp, x + 2, y - 1, height - 1);
                    dp[height][row][col] += getValue(dp, x - 2, y + 1, height - 1);
                    dp[height][row][col] += getValue(dp, x - 2, y - 1, height - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    private int getValue(int[][][] dp, int x, int y, int height) {
        if (x < 0 || x > dp.length || y < 0 || y > dp[0].length) {
            return 0;
        }
        return dp[x][y][height];
    }
}
