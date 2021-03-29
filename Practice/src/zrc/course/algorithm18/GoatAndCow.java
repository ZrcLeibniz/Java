package zrc.course.algorithm18;

/*
牛羊吃草问题
    每次可以吃4的幂次方的草，必须吃，牛羊都很聪明，谁先吃完谁赢，求解先手赢还是后手赢
 */
public class GoatAndCow {
    public String solution(int N) {
        if (N < 5) {
            return (N == 0 || N == 2) ? "羊" : "牛";
        }
        int base = 1;
        while (base <= N) {
            if (solution(N - base).equals("羊")) {
                return "牛";
            }
            if (base > N / 4) {
                break;
            }
            base *= 4;
        }
        return "羊";
    }
}
