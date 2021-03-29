package zrc.course.algorithm18;

/*
    给定一个有序数组，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n-1]，给定
    一个整数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点
 */
public class RopeRange {
    public int solution(int[] arr, int limit) {
        int left = 0;
        int right = 0;
        int result = 0;
        while (left < arr.length) {
            while (right < arr.length && arr[right] - arr[left] < limit) {
                right++;
            }
            result = Math.max(result, right - left);
            left++;
        }
        return result;
    }
}
