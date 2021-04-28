package zrc.everyday;

import java.util.Scanner;

public class Question_20210428_1 {
    private static int solution(int num) {
        int result = 0;
        while (num != 0) {
            num = num & (num - 1);
            result++;
        }
        return  result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int solution = solution(num);
            System.out.println(solution);
        }
    }
}
