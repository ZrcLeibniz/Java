package zrc.everyday;

import java.math.BigInteger;
import java.util.Scanner;

public class Question_20210528_2 {
    public static BigInteger solution(int num) {
        if (num == 1) {
            return new BigInteger("1");
        }
        if (num == 2) {
            return new BigInteger("2");
        }
        BigInteger[] dp = new BigInteger[num];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("2");
        for (int i = 2; i < num; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        return dp[num - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            BigInteger solution = solution(num);
            System.out.println(solution);
        }
    }
}
