package zrc.course.algorithm18;

/*
给定一个N*M的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边长长度
 */
public class MaxLengthMatrix {
    public int solution(int[][] matrix) {
        int max = 0;
        int[][] rightOne = new int[matrix.length][matrix[0].length];
        int[][] downOne = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < rightOne.length; row++) {
            for (int col = rightOne[row].length - 1; col >= 0; col--) {
                if (col == rightOne[row].length) {
                    rightOne[row][col] = rightOne[row][col] == 1 ? 1 : 0;
                }
                rightOne[row][col] = rightOne[row][col] == 1 ? rightOne[row][col + 1] + 1 : 0;
            }
        }
        for (int row = rightOne.length - 1; row >= 0; row--) {
            for (int col = 0; col < rightOne[row].length; col++) {
                if (row == rightOne.length - 1) {
                    rightOne[row][col] = rightOne[row][col] == 1 ? 1 : 0;
                }
                rightOne[row][col] = rightOne[row][col] == 1 ? rightOne[row + 1][col] + 1 : 0;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                for (int border = 1; border < Math.min(matrix.length - row + 1, matrix[row].length - col + 1); border++) {
                    if (rightOne[row][col] >= border && downOne[row][col] >= border) {
                        if (rightOne[row + border - 1][col] >= border) {
                            if (downOne[row][col + border - 1] >= border) {
                                max = Math.max(max, border);
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}
