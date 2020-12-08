package zrc.sort.practice.shell;

public class Shell15 {

    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 2) {
            h = h * 2 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (!greater(a[j], a[j - h])) {
                        exchange(a, j, j- h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
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
