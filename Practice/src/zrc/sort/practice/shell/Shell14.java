package zrc.sort.practice.shell;

public class Shell14 {

    public static void sort(Comparable[] a) {
        int gap = 1;
        while (gap <= a.length / 2) {
            gap = gap * 2 + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i <= a.length - 1; i++) {
                for (int j = i; j >= gap ; j = j - gap) {
                    if (greater(a[j - gap], a[j])) {
                        exchange(a, j - gap, j);
                    } else {
                        break;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
