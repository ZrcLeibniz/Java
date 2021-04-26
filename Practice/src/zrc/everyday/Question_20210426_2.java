package zrc.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_20210426_2 {
    public static int solution(int M, int N) {
        int step = M - N + 1;
        int[] dp = new int[step];
        for (int i = 1; i < step; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            List<Integer> stepResult = getStep(i + N);
            for (Integer integer : stepResult) {
                if (i + integer + N <= M) {
                    dp[i + integer] = Math.min(dp[i + integer], dp[i] + 1);
                }
            }
        }
        if (dp[dp.length - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[dp.length - 1];
        }
    }

    private static List<Integer> getStep(int N) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                result.add(i);
                if (N / i != i) {
                    result.add(N / i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int solution = solution(M, N);
            System.out.println(solution);
        }
    }
}
