package zrc.leetcode.reback;

//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 759 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class RotateImageSolution {
    public void rotate(int[][] matrix) {
        int begin = 0;
        int end = matrix.length - 1;
        while (begin < end) {
            rotateEdge(matrix, begin++, end--);
        }
    }

    private void rotateEdge(int[][] matrix, int begin, int end) {
        int temp = 0;
        for (int i = 0; i < end - begin; i++) {
            temp = matrix[begin][begin + i];
            matrix[begin][begin + i] = matrix[end - i][begin];
            matrix[end - i][begin] = matrix[end][end - i];
            matrix[end][end - i] = matrix[begin + i][end];
            matrix[begin + i][end] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
