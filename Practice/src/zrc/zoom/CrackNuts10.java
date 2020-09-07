package zrc.zoom;

/*
目前有n-1个数字，这些数字的范围是[1, n]，且这个n-1个数字中没有重复的数字，请找到缺失的数字
 */
public class CrackNuts10 {
    public int solution(int[] array, int lim) {
        int count = (lim + 1) * lim / 2;
        int count2 = 0;
        for (int i = 0; i < array.length; i++) {
            count2 += array[i];
        }
        return count - count2;
    }
}
