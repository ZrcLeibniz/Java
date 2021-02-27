package zrc.course.algorithm9;

// 汉诺塔问题
public class HanoiTower {
    public void solution(int N) {
        solution(N, "左", "中", "右");
    }

    private void solution(int N, String from, String to, String other) {
        if (N == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        }
        solution(N - 1, from, other, to);
        System.out.println("Move i from " + from + " to " + to);
        solution(N - 1, other, to, from);
    }
}
