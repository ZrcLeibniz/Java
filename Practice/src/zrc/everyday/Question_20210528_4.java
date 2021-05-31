package zrc.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_20210528_4 {
    private static List<String> process(String table) {
        int index = 0;
        List<String> result = new ArrayList<>();
        while (index < table.length()) {
            if (table.charAt(index) == '"') {
                int begin = ++index;
                while (table.charAt(index) != '"') {
                    index++;
                }
                result.add(table.substring(begin, index));
                index++;
            } else {
                int begin = index;
                while (index < table.length() && table.charAt(index) != ',') {
                    index++;
                }
                result.add(table.substring(begin, index));
            }
            index++;
        }
        return result;
    }

    private static boolean isValid(String s, String name) {
        String[] split = null;
        if (s.contains(" ") && s.contains(",")) {
            split = s.split(", ");
        } else if (s.contains(" ")) {
            split = s.split(" ");
        } else if (s.contains(",")) {
            split = s.split(",");
        } else {
            split = new String[1];
            split[0] = s;
        }
        for (String s1 : split) {
            if (s1.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> table = process(s);
        String name = scanner.nextLine();
        boolean flag = false;
        for (String s1 : table) {
            if (isValid(s1, name)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Important");
        } else {
            System.out.println("Ignore");
        }
    }
}