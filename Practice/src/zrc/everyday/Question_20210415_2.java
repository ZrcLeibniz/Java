package zrc.everyday;

import zrc.Problem;

import java.util.Scanner;

public class Question_20210415_2 {
    private String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F"};

    private String conversion = "";

    private void convert(int number, int system) {
        conversion = arr[number % system] + conversion;
        if (number / system == 0) {
            return;
        }
        convert(number / system, system);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();
        int target = scanner.nextInt();
        Question_20210415_2 problem = new Question_20210415_2();
        problem.convert(source, target);
        System.out.println(problem.conversion);
    }
}
