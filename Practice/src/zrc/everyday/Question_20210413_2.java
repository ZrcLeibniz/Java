package zrc.everyday;

import java.util.Scanner;
import java.util.Stack;

public class Question_20210413_2 {
    public static String solution(String str) {
        String[] temp = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (String string : temp) {
            stack.push(string);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string  = scanner.nextLine();
        String solution = solution(string);
        System.out.println(solution);
    }
}
