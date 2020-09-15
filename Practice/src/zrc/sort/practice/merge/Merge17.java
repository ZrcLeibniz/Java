package zrc.sort.practice.merge;

public class Merge17 {
    private static Comparable[] assist;

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int index = lo;
        int p1 = lo;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1], a[p2])) {
                assist[index++] = a[p1++];
            } else {
                assist[index++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            assist[index++] = a[p1++];
        }
        while (p2 <= hi) {
            assist[index++] = a[p2++];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = assist[i];
        }
    }
}
