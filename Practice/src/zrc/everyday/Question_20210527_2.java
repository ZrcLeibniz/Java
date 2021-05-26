package zrc.everyday;

import java.math.BigInteger;
import java.util.Scanner;

public class Question_20210527_2 {
    public static BigInteger solution(int from, int to) {
        if (from == 1 && to == 1) {
            return new BigInteger("1");
        }
        if (from == 2 && to == 2) {
            return new BigInteger("1");
        }
        if (from == 1 && to == 2) {
            return new BigInteger("2");
        }
        BigInteger[] dp = new BigInteger[to];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        BigInteger result = new BigInteger("0");
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        for (int i = from - 1; i < dp.length; i++) {
            result = result.add(dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            BigInteger solution = solution(from, to);
            System.out.println(solution);
        }
    }
}
