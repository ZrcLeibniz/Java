package zrc.sort.practice.selection;

public class Selection25 {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= a.length - 1; j++) {
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            exchange(a, minIndex, i);
        }
    }

    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
