package zrc;

public class JumpGame {
    public boolean canJump(int[] A) {
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int j = 1; j < n; j++) {
            f[j] = false;
            for (int i = 0; i < j; i++) {
                if (f[i] && A[i] + i >= j) {
                    f[j] = true;
                }
            }
        }
        return f[n - 1];
    }
}
