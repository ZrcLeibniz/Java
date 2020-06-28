package zrc.sort.pratice.quick;

public class Quick05 {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        } else {
            int partition = partition(a, lo, hi);
            sort(a, lo, partition - 1);
            sort(a, partition + 1, hi);
        }
    }

    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable key = a[lo];
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (less(key, a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            while (less(a[++left], key)) {
                if (left == hi) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exchange(a, left, right);
            }
        }
        exchange(a, lo, right);
        return right;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
