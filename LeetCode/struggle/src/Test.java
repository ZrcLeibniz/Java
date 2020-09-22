public class Test {
    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(a);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int high = 0;
        int width = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                high = height[i] > height[j] ? height[j] : height[i];
                width = j - i;
                max = max > high * width ? max : high * width;
            }
        }
        return max;
    }
}
