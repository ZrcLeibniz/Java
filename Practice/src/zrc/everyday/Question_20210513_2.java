package zrc.everyday;

import java.util.Scanner;

public class Question_20210513_2 {
    public static int solution(String stringA, String stringB) {
        int[][] dp = new int[stringA.length() + 1][stringB.length() + 1];
        char[] wordA = stringA.toCharArray();
        char[] wordB = stringB.toCharArray();
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (wordA[i - 1] == wordB[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[wordA.length][wordB.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String stringA = scanner.nextLine();
            String stringB = scanner.nextLine();
            int solution = solution(stringA, stringB);
            System.out.println(solution);
        }
    }
}
