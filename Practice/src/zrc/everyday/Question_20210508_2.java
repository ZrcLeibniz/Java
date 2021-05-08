package zrc.everyday;

import java.util.Scanner;

public class Question_20210508_2 {
    private static boolean solution(String str1, String str2, int p1, int p2) {
        if (p1 == str1.length() && p2 == str2.length()) {
            return true;
        } else if (p1 == str1.length() || p2 == str2.length()){
            return false;
        }
        if (str1.charAt(p1) == '*') {
            return solution(str1, str2, p1, p2 + 1) || solution(str1, str2, p1 + 1, p2 + 1);
        } else if (str1.charAt(p1) == '?' || str1.charAt(p2) == str2.charAt(p2)) {
            return solution(str1, str2, p1 + 1, p2 + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            boolean solution = solution(s1, s2, 0, 0);
            System.out.println(solution);
        }
    }
}
