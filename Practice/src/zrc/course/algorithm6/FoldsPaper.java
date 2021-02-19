package zrc.course.algorithm6;

public class FoldsPaper {
    public void solution(int N) {
        process(1, N, true);
    }

    private void process(int i, int N, boolean flag) {
        if (i == N) {
            return;
        }
        process(i + 1, N, true);
        System.out.println(flag ? "凹" : "凸");
        process(i + 1, N, false);
    }
}
