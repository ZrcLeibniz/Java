package zrc.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_20210430_1 {
    public static boolean process(int x) {
        List<Integer> table = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                table.add(i);
                if (x / i != i && x / i != x) {
                    table.add(x / i);
                }
            }
        }
        int sum = 0;
        for (Integer integer : table) {
            sum += integer;
        }
        return sum == x;
    }

    public static int solution(int N) {
        int result = 0;
        for (int i = N; i > 1; i--) {
            if (process(i)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int solution = solution(n);
            System.out.println(solution);
        }
    }
}
