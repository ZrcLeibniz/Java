package zrc.course.bite;

import java.util.Scanner;

public class Homework_20201212_6 {
    public static void main(String[] args) {
        Homework_20201212_6 main = new Homework_20201212_6();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 2 || n > 20) {
            System.out.println("请输入合法数字");
        } else {
            main.solution(n);
        }
    }

    public static void solution(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print("*");
                } else if (n - j - i - 1 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void solutionII(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print("*");
                } else if (i + j + 1 - n == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
