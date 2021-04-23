package zrc.everyday;

public class Question_20210423_2 {
    public static int solution(int number) {
        number = Math.abs(number);
        String string = Integer.toBinaryString(number);
        char[] table = string.toCharArray();
        int[] dp = new int[table.length];
        dp[0] = table[0] == '1' ? 1 : 0;
        int max = 0;
        for (int i = 1; i < table.length; i++) {
            dp[i] = table[i] == '1' ? dp[i - 1] + 1 : 0;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int a = -3;
        int solution = solution(a);
        System.out.println(solution);
    }
}
