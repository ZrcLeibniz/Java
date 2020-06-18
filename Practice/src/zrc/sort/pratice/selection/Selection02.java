package zrc.sort.pratice.selection;

public class Selection02 {
    public static void sort(Comparable[] a){
        int minIndex;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (greater(a[minIndex], a[j])){
                    minIndex = j;
                }
            }
            exchange(a, minIndex, i);
        }
    }

    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    private static void exchange(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
