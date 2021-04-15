package zrc.everyday;

import java.util.Scanner;

public class Question_20210415_1 {
    private static int[] solution(int aSubB, int bSubC, int aAddB, int bAddC) {
        double A = (aAddB + aSubB) / 2.0;
        double B = (bAddC + bSubC) / 2.0;
        double C = bAddC - B;
        if (A < 0 || B < 0 || C < 0 || A - (int) A != 0 || B - (int) B != 0 || C - (int) C != 0) {
            return new int[0];
        }
        return new int[]{(int) A, (int) B, (int) C};
    }

    public static void main(String[] args) {
        int candy[] = new int[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            candy[i] = scanner.nextInt();
        }
        int[] solution = solution(candy[0], candy[1], candy[2], candy[3]);
        if (solution.length == 0) {
            System.out.println("No");
            return;
        }
        for (int value : solution) {
            System.out.print(value + " ");
        }
    }
}
