package zrc.course.bite.sort;

public class MergeSort {
    public void sort(int[] arr) {

    }

    private void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int index = 0;
        while (p1 <= m && p2 <= r) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }
}

// 归并排序的非递归写法
class MergeSortForLoop {
    private void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int index = 0;
        while (p1 <= m && p2 <= r) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i *= 2) {
            for (int j = 0; j < arr.length; j = j + 2 * i) {
                int low = j;
                int mid = j + i;
                if (mid > arr.length) {
                    continue;
                }
                int high = mid + i;
                if (high > arr.length) {
                    high = arr.length;
                }
                merge(arr, low, mid, high);
            }
        }
    }
}