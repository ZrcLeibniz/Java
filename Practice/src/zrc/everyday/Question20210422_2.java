package zrc.everyday;

import java.util.Scanner;

public class Question20210422_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int solution = solution(X, Y);
            System.out.println(solution);
        }
    }

    public static int solution(int X, int Y) {
        return process(X - 1, Y - 1, 0, 0);
    }

    private static int process(int X, int Y, int curX, int curY) {
        if (curX > X || curY > Y) {
            return 0;
        }
        if (curX == X && curY == Y) {
            return 1;
        }
        int choiceI = process(X, Y, curX + 1, curY);
        int choiceII = process(X, Y, curX, curY + 1);
        return choiceI + choiceII;
    }
}
