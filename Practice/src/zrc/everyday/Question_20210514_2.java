package zrc.everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question_20210514_2 {
    public static String solution(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int index = 0;
        String result = "yyds";
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            int indexKey = s.indexOf(key);
            if (map.get(key) == 1) {
                if (result.equals("yyds")) {
                    result = key.toString();
                    index = indexKey;
                } else if (index > indexKey) {
                    result = key.toString();
                    index = indexKey;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String solution = solution(s);
            if (solution.equals("yyds")) {
                System.out.println(-1);
            } else {
                System.out.println(solution);
            }
        }
    }
}
