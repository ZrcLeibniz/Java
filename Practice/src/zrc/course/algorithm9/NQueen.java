package zrc.course.algorithm9;

// N皇后问题
// 在N*N棋盘上要摆N个皇后，要求任何两个皇后不同列、不同行、也不在同一条斜线上
// 给定一个整数n，返回n皇后的摆法有多少种
public class NQueen {
    public int solution(int N) {
        if (N < 1) {
            return 0;
        }
        int[] record = new int[N];
        return process(0, record);
    }

    private int process(int i, int[] record) {
        if (i == record.length) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record);
            }
        }
        return res;
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(k - i) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }
}
