package zrc.everyday;

import java.util.Scanner;

public class Question_20210507_2 {
    public static String solution(String numOne, String numTwo) {
        StringBuilder result = new StringBuilder();
        StringBuilder one = new StringBuilder(numOne).reverse();
        StringBuilder two = new StringBuilder(numTwo).reverse();
        int index = 0;
        int carry = 0;
        while (index < one.length() || index < two.length()) {
            int num1 = index >= one.length() ? 0 : one.charAt(index) - '0';
            int num2 = index >= two.length() ? 0 : two.charAt(index) - '0';
            int sum = num1 + num2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            index++;
        }
        if (carry != 0) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String numOne = scanner.next();
            String numTwo = scanner.next();
            String add = solution(numOne, numTwo);
            System.out.println(add);
        }
    }
}
