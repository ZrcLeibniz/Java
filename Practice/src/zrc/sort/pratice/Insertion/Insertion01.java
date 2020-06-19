package zrc.sort.pratice.Insertion;

public class Insertion01 {
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (greater(a[j - 1], a[j])){
                    exchange(a, j - 1, j);
                }else{
                    break;
                }
            }
        }
    }

    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    public static void exchange(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
