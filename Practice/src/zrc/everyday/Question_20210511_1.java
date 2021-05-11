package zrc.everyday;

import java.util.Scanner;

public class Question_20210511_1 {
    public static String solution(String str) {
        StringBuilder result = new StringBuilder(str);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            String solution = solution(str);
            System.out.println(solution);
        }
    }
}
