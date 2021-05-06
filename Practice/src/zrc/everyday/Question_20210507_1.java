package zrc.everyday;

import java.util.Scanner;

public class Question_20210507_1 {
    public static int solution(int N) {
        if (N < 3) {
            return -1;
        } else {
            return N % 2 != 0 ? 2 : N % 4 == 0 ? 3 : 4;
        }
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
