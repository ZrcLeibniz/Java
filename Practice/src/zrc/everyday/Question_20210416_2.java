package zrc.everyday;

import java.util.Scanner;

public class Question_20210416_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
