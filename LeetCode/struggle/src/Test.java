import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int reverse = reverse(123);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
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
