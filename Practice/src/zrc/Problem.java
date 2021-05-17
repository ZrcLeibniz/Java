package zrc;


import java.util.Scanner;

public class Problem {
     public static String solution(String num) {
         while (num.length() != 1) {
             num = process(num);
         }
         return num;
     }

     private static String process(String num) {
         int result = 0;
         for (int i = 0; i < num.length(); i++) {
             result += num.charAt(i) - '0';
         }
         return Integer.toString(result);
     }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         while (scanner.hasNext()) {
             String num = scanner.next();
             String solution = solution(num);
             System.out.println(solution);
         }
    }
}