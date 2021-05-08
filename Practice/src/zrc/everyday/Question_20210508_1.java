package zrc.everyday;

import java.util.Scanner;

public class Question_20210508_1 {
    public static int solution(int month) {
        if (month < 3) {
            return 1;
        }
        int[] dp = new int[month + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[month];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();
            int solution = solution(month);
            System.out.println(solution);
        }
    }
}
