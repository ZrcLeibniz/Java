package zrc.course.algorithm18;

/*
有一些排成一行的正方形。每个正方形已经没染成红色或者绿色。
现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色，这个正方形的颜色将会被覆盖
现在的目标是在染完色之后，每个红色R都比每个绿色G距离最左侧近
最少需要染几个正方形
 */
public class ColorOfSquarePoint {
    public int solution(String s) {
        int[] leftGreen = new int[s.length() + 1];
        int[] rightRed = new int[s.length() + 1];
        leftGreen[0] = 0;
        rightRed[s.length()] = 0;
        char[] chars = s.toCharArray();
        int left = 1;
        int right = rightRed.length - 2;
        while (left < leftGreen.length && right >= 0) {
            leftGreen[left] = (chars[left] == 'G' ? 1 : 0) + leftGreen[left - 1];
            rightRed[right] = (chars[right] == 'R' ? 1 : 0) + rightRed[right + 1];
            left++;
            right--;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= s.length(); i++) {
            min = Math.min(min, leftGreen[i] + rightRed[i]);
        }
        return min;
    }
}
