package zrc.everyday;

import java.util.Scanner;

public class Question_20210422 {
    public static int solution(int x) {
        int result = 0;
        while (x > 0) {
            result += x / 5;
            x = x / 5;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int solution = solution(x);
            System.out.println(solution);
        }
    }
}
