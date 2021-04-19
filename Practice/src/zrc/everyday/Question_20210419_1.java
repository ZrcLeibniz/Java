package zrc.everyday;

import java.util.Scanner;

public class Question_20210419_1 {
    private static int solution(int A, int B) {
        int max = Math.max(A, B);
        int min = Math.min(A, B);
        if (max % min == 0) {
            return max;
        }
        int result = max;
        while (true) {
            if (result % max != 0 || result % min != 0) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int solution = solution(i, j);
        System.out.println(solution);
    }
}
