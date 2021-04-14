package zrc.everyday;

import java.util.Scanner;

// 找到一个字符串中最长的连续数组，并打印
public class Question_20210414_1 {
    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static int[] solution(String s) {
        char[] string = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = isNumber(string[0]) ? 1 : 0;
        int maxIndex = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = isNumber(string[i]) ? dp[i - 1] + 1 : 0;
            if (dp[i] > maxLength) {
                maxIndex = i;
                maxLength = dp[i];
            }
        }
        return new int[]{maxIndex, maxLength};
    }

    private static void printMaxLengthNumber(String s) {
        int[] solution = solution(s);
        if (solution[0] == Integer.MIN_VALUE) {
            System.out.println("");
        } else {
            System.out.println(s.substring(solution[0] - solution[1] + 1, solution[0] + 1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string  = scanner.nextLine();
        printMaxLengthNumber(string);
    }
}
