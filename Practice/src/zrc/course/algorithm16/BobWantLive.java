package zrc.course.algorithm16;

public class BobWantLive {
    public String solution(int limitX, int limitY, int x, int y, int step) {
        long all = (long) Math.pow(4, step);
        long live = process(limitX, limitY, x, y, step);
        return String.valueOf(live) + "/" + String.valueOf(all);
    }

    private long process(int limitX, int limitY, int x, int y, int step) {
        if (x < 0 || x >= limitX || y < 0 || y >= limitY) {
            return 0;
        }
        if (step == 0) {
            return 1;
        }
        long live = 0;
        live = process(limitX, limitY, x + 1, y, step - 1)
                + process(limitX, limitY, x - 1, y, step - 1)
                + process(limitX, limitY, x, y + 1, step - 1)
                + process(limitX, limitY, x, y - 1, step - 1);
        return live;
    }

    public String dynamicProgramming(int limitX, int limitY, int x, int y, int step) {
        if (x < 0 || x >= limitX || y < 0 || y >= limitY) {
            return String.valueOf(0);
        }
        long[][][] dp = new long[limitX][limitY][step + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j][1] = 1;
            }
        }
        for (int height = 1; height <= step; height++) {
            for (int row = 0; row < limitX; row++) {
                for (int col = 0; col < limitY; col++) {
                    dp[row][col][height] += getValue(dp, x + 1, y, height - 1);
                    dp[row][col][height] += getValue(dp, x - 1, y, height - 1);
                    dp[row][col][height] += getValue(dp, x, y + 1, height - 1);
                    dp[row][col][height] += getValue(dp, x, y - 1, height - 1);
                }
            }
        }
        long live = dp[x][y][step];
        long all = (long) Math.pow(4, step);
        return String.valueOf(live) + "/" + String.valueOf(all);
    }

    private long getValue(long[][][] dp, int x, int y, int height) {
        if (x < 0 || x >= dp.length || y < 0 || y >= dp[x].length) {
            return 0;
        }
        return dp[x][y][height];
    }
}
