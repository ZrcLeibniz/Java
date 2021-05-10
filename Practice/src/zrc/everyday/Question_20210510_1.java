package zrc.everyday;

import java.util.Scanner;

public class Question_20210510_1 {
    public static int solution(int num) {
        int result = 0;
        while (num > 2) {
            result++;
            num -= 3;
            num++;
        }
        return num == 2 ? result + 1 : result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n != 0) {
                int solution = solution(n);
                System.out.println(solution);
            } else {
                break;
            }
        }
    }
}
