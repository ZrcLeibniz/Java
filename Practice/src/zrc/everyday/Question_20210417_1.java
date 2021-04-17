package zrc.everyday;

import java.util.Scanner;

public class Question_20210417_1 {
    private static int solution(int m, int n) {
        int[][] table = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 0) {
                    count++;
                    if (i + 2 < m) {
                        table[i + 2][j] = 1;
                    }
                    if (j + 2 < n) {
                        table[i][j + 2] = 1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int solution = solution(m, n);
        System.out.println(solution);
    }
}
