package zrc.everyday;

import java.util.Scanner;

public class Question_20210424_1 {
    public static int solution(int rope) {
        if (rope == 1) {
            return 1;
        }
        int[] dp = new int[rope + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = dp[i / 2 + 1] + 1;
            }
        }
        return dp[rope];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                int solution = solution(arr[i]);
                System.out.println(solution);
            }
            break;
        }
    }
}
