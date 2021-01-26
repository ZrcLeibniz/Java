package zrc.leetcode.reback;

//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 292 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SpiralMatrixIISolution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int begin = 0;
        int end = n - 1;
        int num = 1;
        while (begin <= end) {
            num = generate(result, begin++, end--, num);
        }
        return result;
    }

    private int generate(int[][] matrix, int begin, int end, int n) {
        if (begin == end) {
            matrix[begin][begin] = n++;
            return n;
        }
        int R = begin;
        int C = begin;
        while (C < end) {
            matrix[begin][C++] = n++;
        }
        while (R < end) {
            matrix[R++][end] = n++;
        }
        while (C > begin) {
            matrix[end][C--] = n++;
        }
        while (R > begin) {
            matrix[R--][begin] = n++;
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
