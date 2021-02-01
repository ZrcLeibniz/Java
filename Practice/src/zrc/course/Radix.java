package zrc.course;

public class Radix {
    public void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maBites(arr));
    }

    public void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0;
        int j = 0;
        int[] bucket = new int[R - L - 1];
        for (int d = 0; d < digit; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i++) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i < R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private int getDigit(int num, int d) {
        return ((num / ((int) Math.pow(10, d - 1))) % 10);
    }

    private int maBites(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            max = Math.max(max, value);
        }
        return String.valueOf(max).length();
    }

}
