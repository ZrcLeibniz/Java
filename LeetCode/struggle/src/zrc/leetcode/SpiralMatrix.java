package zrc.leetcode;

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
// 👍 581 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        int sr = 0;
        int er = matrix.length - 1;
        int sc = 0;
        int ec = matrix[0].length - 1;
        while (sr <= er && sc <= ec) {
            saveSpiral(result, matrix, sr++, sc++, er--, ec--);
        }
        return result;
    }

    public void saveSpiral(List<Integer> result, int[][] matrix, int sr, int sc, int er, int ec) {
        if (sr == er) {
            for (int i = sc; i <= ec; i++) {
                result.add(matrix[sr][i]);
            }
        } else if (sc == ec) {
            for (int i = sr; i <= er; i++) {
                result.add(matrix[i][sc]);
            }
        } else {
            int R = sr;
            int C = sc;
            while (C < ec) {
                result.add(matrix[sr][C++]);
            }
            while (R < er) {
                result.add(matrix[R++][ec]);
            }
            while (C > sc) {
                result.add(matrix[er][C--]);
            }
            while (R > sr) {
                result.add(matrix[R--][sc]);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
