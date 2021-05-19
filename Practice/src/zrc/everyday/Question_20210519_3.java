package zrc.everyday;

import java.util.Scanner;

public class Question_20210519_3 {
    public static boolean solution(int a, int b, int c) {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            boolean solution = solution(a, b, c);
            if (solution) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
