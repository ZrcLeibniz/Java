package zrc.everyday;

public class Question_20210423_1 {
    public static int solution(int a, int b) {
        int maxNode = Math.max(a, b);
        int minNode = maxNode == a ? b : a;
        while (true) {
            int maxLevel = getHeight(maxNode);
            int minLevel = getHeight(minNode);
            while (minLevel != maxLevel) {
                maxNode /= 2;
                maxLevel = getHeight(maxNode);
            }
            if (minNode == maxNode) {
                return minNode;
            }
            int minFather = minNode / 2;
            int maxFather = maxNode / 2;
            while (minFather != maxFather) {
                minFather /= 2;
                maxFather /= 2;
            }
            return minFather;
        }
    }

    private static int getHeight(int a) {
        int result = 1;
        while (a > 1) {
            a /= 2;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int solution = solution(8, 2);
        System.out.println(solution);
    }
}
