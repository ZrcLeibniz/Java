package zrc.everyday;

import java.util.Scanner;

public class Question_20210412_2 {
    private static String solution(String source, String target) {
        char[] chars = target.toCharArray();
        for (char c : chars) {
            source = source.replace(String.valueOf(c), "");
        }
        return source;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String solution = solution(str1, str2);
        System.out.println(solution);
    }
}
