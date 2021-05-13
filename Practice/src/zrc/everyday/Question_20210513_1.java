package zrc.everyday;

import java.util.Scanner;

public class Question_20210513_1 {
    public static int solution(int a, int[] b) {
        for (int i : b) {
            if (a >= i) {
                a += i;
            } else {
                a += process(a, i);
            }
        }
        return a;
    }

    private static int process(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            int a = scanner.nextInt();
            int[] b = new int[length];
            for (int i = 0; i < length; i++) {
                b[i] = scanner.nextInt();
            }
            int solution = solution(a, b);
            System.out.println(solution);
        }
    }
}
