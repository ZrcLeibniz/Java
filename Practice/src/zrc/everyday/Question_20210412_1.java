package zrc.everyday;

import java.util.Arrays;
import java.util.Scanner;

public class Question_20210412_1 {
    private static long solution(int n, int[] point) {
        Arrays.sort(point);
        long result = 0;
        int index = point.length - 2;
        for (int i = n; i > 0; i--) {
            result += point[index];
            index -= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int[] point = null;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            point = new int[n * 3];
            for (int i = 0; i < point.length; i++) {
                point[i] = scanner.nextInt();
            }
        }
        long solution = solution(n, point);
        System.out.println(solution);
    }
}
