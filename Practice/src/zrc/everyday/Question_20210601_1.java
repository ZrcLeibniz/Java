package zrc.everyday;

import java.util.Scanner;

public class Question_20210601_1 {
    public static int solution(String[][] room, int x, int y) {
        return process(room, x, y);
    }

    private static int process(String[][] matrix, int curX, int curY) {
        if (curX < 0 || curY < 0 || curX >= matrix.length || curY >= matrix[0].length || matrix[curX][curY].equals("#")) {
            return 0;
        }
        int result = 1;
        matrix[curX][curY] = "#";
        result += process(matrix, curX + 1, curY);
        result += process(matrix, curX - 1, curY);
        result += process(matrix, curX, curY + 1);
        result += process(matrix, curX, curY - 1);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            String[][] room = new String[row][col];
            int curX = 0;
            int curY = 0;
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    String cur = scanner.next();
                    if (cur.equals("@")) {
                        curX = i;
                        curY = j;
                        room[i][j] = ".";
                    }
                    room[i][j] = cur;
                }
            }
            int solution = solution(room, curX, curY);
            System.out.println(solution);
        }
    }
}
