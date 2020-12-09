package zrc.sort.practice.selection;

public class Selection26 {

    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (greater(array[minIndex], array[j])) {
                    minIndex = j;
                }
            }
            exchange(array, minIndex, i);
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
