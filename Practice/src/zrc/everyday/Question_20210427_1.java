package zrc.everyday;

import java.util.Scanner;

public class Question_20210427_1 {
    public static int solution(int year, int month, int day) {
        int[] table = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                table[1] = 29;
            }
        } else {
            if (year % 4 == 0) {
                table[1] = 29;
            }
        }
        int result = 0;
        for (int i = 0; i < month - 1; i++) {
            result += table[i];
        }
        result += day;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int solution = solution(year, month, day);
            System.out.println(solution);
        }
    }
}
