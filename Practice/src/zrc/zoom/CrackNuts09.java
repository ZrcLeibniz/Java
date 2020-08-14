package zrc.zoom;

/*
使用递归进行插入排序
 */
public class CrackNuts09 {
    public static void insertSort(int[] arr, int k) {
        if (k == 0) {
            return;
        }
        insertSort(arr, k - 1);
        int x = arr[k];
        int index = k - 1;
        while (x < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index] = x;
    }
}
