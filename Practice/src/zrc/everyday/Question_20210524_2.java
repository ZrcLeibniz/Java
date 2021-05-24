package zrc.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_20210524_2 {
    public static List<Integer> solution(int num) {
        List<Integer> result = new ArrayList<>();
        boolean flag = false;
        for (int i = 2; i <= num; i++) {
            if (isValid(i)) {
                if (num % i == 0) {
                    result.add(i);
                    List<Integer> solution = solution(num / i);
                    result.addAll(solution);
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }

    private static boolean isValid(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (isValid(num)) {
                System.out.println(num + " = " + num);
            } else {
                List<Integer> solution = solution(num);
                StringBuilder result = new StringBuilder();
                result.append(num);
                result.append(" =");
                for (Integer integer : solution) {
                    result.append(" ");
                    result.append(integer);
                    result.append(" ");
                    result.append("*");
                }
                result.deleteCharAt(result.length() - 1);
                result.deleteCharAt(result.length() - 1);
                System.out.println(result);
            }
        }
    }
}
