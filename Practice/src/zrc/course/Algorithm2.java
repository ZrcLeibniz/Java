package zrc.course;

import java.util.Arrays;
import java.util.Random;

public class Algorithm2 {
    // 递归求一个数组的最大值
    public int solution(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) / 2);
        int maxLeft = process(arr, l, mid);
        int maxRight = process(arr, mid + 1, r);
        return Math.max(maxLeft, maxRight);
    }

    // 给定一个数组和一个目标值，将小于等于目标值的放左边，大于目标值的放右边
    public void solutionII(int[] arr, int target) {
        int left = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                swap(arr, ++left, i);
            }
        }
    }

    // 给定一个数组和一个目标值，将小于目标值的放左边，等于目标值的放中间，大于目标值的放右边
    public void solutionIII(int[] arr, int target) {
        int left = -1;
        int right = arr.length;
        int cur = 0;
        while (cur < right) {
            if (arr[cur] == target) {
                cur++;
            } else if (arr[cur] < target) {
                swap(arr, ++left, cur++);
            } else {
                swap(arr, --right, cur);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
master公式：
    T(N) = a * T(N / b) + O(N ^ d)

    1) log(b, a) > d -> 复杂度为O(N ^ log(b, a))
    2) log(b, a) = d -> 复杂度为O(N ^ d * logN)
    3) log(b, a) < d -> 复杂度为O(N ^ d)
 */

class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) / 2);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
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

// 求小和
class SumOfSmall {
    public int getSmallSum (int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return mergeSort(copyArr, 0, copyArr.length - 1);
    }

    private int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int index = 0;
        int result = 0;
        while (p1 <= m && p2 <= r) {
            result += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            help[index++] =  arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return result;
    }
}

// 求一个数组中有多少个逆序对
class ReverseOrderPair {
    private int  getReverseOrderPair(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return mergeSort(copyArr, 0, copyArr.length - 1);
    }

    private int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = m - 1;
        int p2 = r;
        int result = 0;
        int index = help.length - 1;
        while (p1 >= l && p2 >= m) {
            result += arr[p1] > arr[p2] ? (p2 - m + 1) : 0;
            help[index--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= l) {
            help[index--] = arr[p1--];
        }
        while (p2 >= m) {
            help[index--] = arr[p2--];
        }
        for (int i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return result;
    }
}

class QuickSort {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, l);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] == arr[r]) {
                l++;
            } else if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else {
                swap(arr, --more, l);
            }
        }
        swap(arr, r, more);
        int[] result = new int[2];
        result[0] = less + 1;
        result[1] = more - 1;
        return result;
    }
}