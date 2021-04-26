package zrc.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_20210426_1 {
    public static List<String> solution(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '"') {
                while (i < chars.length && chars[i] != ' ') {
                    cur.append(chars[i]);
                    i++;
                }
                result.add(cur.toString());
                cur = new StringBuilder();
            } else {
                i++;
                while (i < chars.length && chars[i] != '"') {
                    cur.append(chars[i]);
                    i++;
                }
                result.add(cur.toString());
                cur = new StringBuilder();
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        List<String> solution = solution(next);
        System.out.println(solution.size());
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
