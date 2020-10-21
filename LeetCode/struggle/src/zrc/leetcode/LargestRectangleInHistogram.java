package zrc.leetcode;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 966 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class LargeRectangleInHistogramSolution {
    public static int largestRectangleArea(int[] heights) {
        int[] temp = new int[heights.length + 2];
        temp[0] = 0;
        System.arraycopy(heights, 0, temp, 1, heights.length);
        temp[heights.length + 1] = 0;
        heights = temp;
        Stack<Integer> stack = new Stack<>();
        stack.push(heights[0]);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heights[i] < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int curWeigh = i - stack.pop() - 1;
                maxArea = Math.max(maxArea, curHeight * curWeigh);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
