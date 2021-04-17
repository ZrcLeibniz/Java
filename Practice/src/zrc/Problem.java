package zrc;


import java.util.Scanner;

public class Problem {
    private static int solution(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int index = 0;
        if (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        int flag = 1;
        if (str.charAt(index) == '-') {
            flag = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        int count = 0;
        while (index < str.length()) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                return 0;
            }
            int num = str.charAt(index) - '0';
            if (count > Integer.MAX_VALUE / 10 || (count == Integer.MAX_VALUE / 10 && num > 7)) {
                return Integer.MAX_VALUE;
            }
            if (count < Integer.MIN_VALUE / 10 || (count == Integer.MIN_VALUE / 10 && num < -8)) {
                return Integer.MIN_VALUE;
            }
            count = count * 10 + flag * num;
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "+2147483647";
        int solution = solution(s);
        System.out.println(solution);
    }
}