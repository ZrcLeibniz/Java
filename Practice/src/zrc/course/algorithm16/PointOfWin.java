package zrc.course.algorithm16;

/*
游戏的获胜者
 */
public class PointOfWin {
    public int winner(int[] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        return Math.max(pre(matrix, 0, matrix.length - 1), post(matrix, 0, matrix.length - 1));
    }

    private int pre(int[] matrix, int begin, int end) {
        if (begin == end) {
            return matrix[begin];
        }
        return Math.max(matrix[begin] + post(matrix, begin + 1, end), matrix[end] + post(matrix, begin, end - 1));
    }

    private int post(int[] matrix, int begin, int end) {
        if (begin == end) {
            return 0;
        }
        return Math.min(pre(matrix, begin + 1, end), pre(matrix, begin, end - 1));
    }

    public int dynamicProgramming(int[] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] pre = new int[matrix.length][matrix.length];
        int[][] post = new int[matrix.length][matrix.length];
        for (int i = 0; i < pre.length; i++) {
            pre[i][i] = matrix[i];
        }
        int row = 0;
        int col = 1;
        while (col < matrix.length) {
            int i = row;
            int j = col;
            while (i < matrix.length && j < matrix.length) {
                pre[i][j] = Math.max(matrix[i] + post[i + 1][j], matrix[j] + post[i][j - 1]);
                post[i][j] = Math.min(pre[i + 1][j], pre[i][j - 1]);
                i++;
                j++;
            }
            col++;
        }
        return Math.max(pre[0][matrix.length - 1], post[0][matrix.length - 1]);
    }
}
