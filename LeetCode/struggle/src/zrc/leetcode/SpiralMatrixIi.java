package zrc.leetcode;

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
// 👍 285 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SpiralMatrixIISolution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        initialization(result);
        return result;
    }

    private void initialization(int[][] arr) {
        int num = 1;
        int begin = 0;
        int end = arr.length - 1;
        while (num <= arr.length * arr.length) {
            num = partInitialization(arr, begin++, end--, num);
        }
    }

    private int partInitialization(int[][] arr, int begin, int end, int num) {
        while (num == arr.length * arr.length) {
            arr[begin][begin] = num++;
            return num;
        }
        int R = begin;
        int C = begin;
        while (C < end) {
            arr[begin][C++] = num++;
        }
        while (R < end) {
            arr[R++][end] = num++;
        }
        while (C > begin) {
            arr[end][C--] = num++;
        }
        while (R > begin) {
            arr[R--][begin] = num++;
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
