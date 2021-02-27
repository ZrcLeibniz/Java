package zrc.course.algorithm9;

// 给定一个整型数组arr，代表数值不同的纸牌拍成一条线
// 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿
// 每个玩家只能拿走最左或最右的纸牌
// 请返回最后获胜者的分数
// 玩家们都异常聪明
public class WinPoint {
    public int solution(int[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        return Math.max(f(points, 0, points.length - 1), s(points, 0, points.length - 1));
    }

    private int f(int[] points, int i, int j) {
        if (i == j) {
            return points[i];
        }
        return Math.max(points[i] + s(points, i + 1, j), points[j] + s(points, i, j - 1));
    }

    private int s(int[] points, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(points, i + 1, j), f(points, i, j - 1));
    }
}
