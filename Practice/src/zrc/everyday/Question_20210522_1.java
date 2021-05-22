package zrc.everyday;

import java.util.Scanner;

public class Question_20210522_1 {
    public static String solution(String password) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char cur = password.charAt(i);
            if (cur == ' ') {
                result.append(cur);
                continue;
            }
            char temp = (char)((cur  - 'A' + 21) % 26 + 'A');
            result.append(temp);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            String solution = solution(password);
            System.out.println(solution);
        }
    }
}
