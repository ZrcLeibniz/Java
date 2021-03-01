package zrc.course.algorithm11;

public class CountOfIsland {
    public int solution(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    infect(matrix, i, j);
                    result += 1;
                }
            }
        }
        return result;
    }

    private void infect(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 0) {
            return;
        }
        matrix[i][j] = 0;
        if (i - 1 > 0) {
            infect(matrix, i - 1, j);
        }
        if (i + 1 < matrix.length) {
            infect(matrix, i + 1, j);
        }
        if (j - 1 > 0) {
            infect(matrix, i, j - 1);
        }
        if (j + 1 < matrix[i].length) {
            infect(matrix, i, j + 1);
        }
    }
}
