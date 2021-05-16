package zrc.everyday;

import java.util.*;

public class Question_20210516_2 {
    private static class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static List<List<point>> solution(int[][] maze) {
        List<List<point>> result = new ArrayList<>();
        Deque<point> path = new ArrayDeque<>();
        process(result, path, 0, 0, maze);
        result.get(0).add(new point(maze.length - 1, maze[0].length - 1));
        return result;
    }

    private static void process(List<List<point>> result, Deque<point> path, int curX, int curY, int[][] maze) {
        if (curX == maze.length - 1 && curY == maze[0].length - 1) {
            result.add(new ArrayList<point>(path));
            return;
        }
        if (curX < 0 || curX >= maze.length || curY < 0 || curY >= maze[0].length || maze[curX][curY] == 1) {
            return;
        }
        path.addLast(new point(curX, curY));
        process(result, path, curX + 1, curY, maze);
        process(result, path, curX, curY + 1, maze);
        path.removeLast();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[][] maze = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            List<List<point>> solution = solution(maze);
            for (List<point> points : solution) {
                for (point point : points) {
                    System.out.println(point);
                }
            }
        }
    }
}
