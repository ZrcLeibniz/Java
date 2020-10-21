import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] heights = {2, 1, 2};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }

    public static int largestRectangleArea(int[] heights) {
        int[] temp = new int[heights.length + 2];
        temp[0] = 0;
        System.arraycopy(heights, 0, temp, 1, heights.length);
        temp[heights.length + 1] = 0;
        heights = temp;
        Stack<Integer> stack = new Stack<>();
        stack.push(heights[0]);
        int maxArea = 0;
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int curWeigh = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, curHeight * curWeigh);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
