package zrc.everyday;

import java.util.ArrayList;
import java.util.Scanner;

public class Question_20210416_1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner  = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int solution = solution(A, B);
        System.out.println(solution);
    }

    private static int solution(String A, String B) {
        ArrayList<String> table = new ArrayList<>();
        for (int i = 0; i <= A.length(); i++) {
            String pre = A.substring(0, i);
            String post = A.substring(i, A.length());
            String cur = pre + B + post;
            table.add(cur);
        }
        int result = 0;
        for (String s : table) {
            result += isValid(s) ? 1 : 0;
        }
        return result;
    }

    private static boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
