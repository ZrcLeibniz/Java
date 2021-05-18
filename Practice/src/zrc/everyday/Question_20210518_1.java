package zrc.everyday;

public class Question_20210518_1 {
    public static int solution(int target) {
        if (target < 2) {
            return target;
        }
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) {
            dp[i] = 1;
            int cur = i - 1;
            while (cur >= 0) {
                dp[i] += dp[cur];
                cur--;
            }
        }
        return dp[target - 1];
    }

    public static void main(String[] args) {
        int solution = solution(4);
        System.out.println(solution);
    }
}
