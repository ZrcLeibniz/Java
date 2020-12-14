package zrc.leetcode;

//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 401 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MaxAreaOfIslandSolution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null || grid.length == 0) {
            return maxArea;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else {
                    int area = landArea(grid, i, j);
                    maxArea = maxArea > area ? maxArea : area;
                }
            }
        }
        return maxArea;
    }

    private int landArea(int[][] grid, int row, int col) {
        int limRow = grid.length;
        int limCol = grid[0].length;
        if (row < 0 || col < 0 || row >= limRow || col >= limCol || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1
                + landArea(grid, row + 1, col)
                + landArea(grid, row - 1, col)
                + landArea(grid, row, col + 1)
                + landArea(grid, row, col - 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
