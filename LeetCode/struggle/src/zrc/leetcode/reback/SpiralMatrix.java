package zrc.leetcode.reback;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 584 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int sRow = 0;
        int sCol = 0;
        int eRow = matrix.length - 1;
        int eCol = matrix[0].length - 1;
        while (sRow <= eRow && sCol <= eCol) {
            process(result, matrix, sRow++, sCol++, eRow--, eCol--);
        }
        return result;
    }

    private void process(List<Integer> result, int[][] matrix, int sRow, int sCol, int eRow, int eCol) {
        if (sRow == eRow) {
            for (int i = sCol; i <= eCol; i++) {
                result.add(matrix[sRow][i]);
            }
        } else if (sCol == eCol) {
            for (int i = sRow; i <= eRow; i++) {
                result.add(matrix[i][sRow]);
            }
        } else {
            int R = sRow;
            int C = sCol;
            while (C < eCol) {
                result.add(matrix[sRow][C++]);
            }
            while (R < eRow) {
                result.add(matrix[R++][eCol]);
            }
            while (C > sCol) {
                result.add(matrix[eRow][C--]);
            }
            while (R > sRow) {
                result.add(matrix[R--][sCol]);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
