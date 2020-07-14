package zrc.sort.practice.selection;

public class Selection01 {
    public static void sort(Comparable[] a){
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[min], a[j])){
                    min = j;
                }
            }
            exchange(a, min, i);
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
