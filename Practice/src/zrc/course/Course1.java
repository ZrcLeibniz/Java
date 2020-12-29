package zrc.course;


import java.util.Arrays;

public class Course1 {
    public static void main(String[] args) {
        int[] arr = {6, 1, 7, 33, 91, 41, 45, 77, 88, 65, 23, 18, 56, 65};
//        Solution.solution1(arr, 2);
        Solution.solution2(arr, 77);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    // 给定一个数组arr和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边
    public static void solution1(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (left < mid && right > mid) {
            while (arr[left] <= num) {
                left++;
            }
            while (arr[right] > num) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    // 荷兰国旗问题:给定一个数组arr和一个数num，请把小于num的数放在数组的左边，等于num的放在数组中间，大于num的放在数组的右边
    public static int[] solution2(int[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while (cur < more) {
            if (arr[cur] == num) {
                cur++;
            } else if (arr[cur] < num) {
                int temp = arr[cur];
                arr[cur++] = arr[++less];
                arr[less] = temp;
            } else if (arr[cur] > num) {
                int temp = arr[cur];
                arr[cur] = arr[--more];
                arr[more] = temp;
            }
        }
        return new int[]{less + 1, more - 1};
    }
}

// 随机快速排序&使用荷兰国旗问题改进快速排序
// 时间复杂度O(N*logN) 额外空间复杂度O(logN)
class Quick {
    public static void quickSort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int L, int R) {
        if (L < R) {
            exchange(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] mid = partition(arr, L, R);
            quickSort(arr, L, mid[0] - 1);
            quickSort(arr, mid[1] + 1, R);
        }
    }

    private static int[] partition(Comparable[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (greater(arr[L], arr[R])) {
                exchange(arr, ++less, L++);
            } else if (greater(arr[R], arr[L])) {
                exchange(arr, --more, L);
            } else {
                L++;
            }
        }
        exchange(arr, more, R);
        return new int[]{less + 1, more};
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

// 堆排序
class heap {
    public static void heapSort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        exchange(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            exchange(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(Comparable[] arr, int index) {
        while (greater(arr[index], arr[(index - 1) / 2])) {
            exchange(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void heapify(Comparable[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && greater(arr[left + 1], arr[left]) ? left + 1 : left;
            largest = greater(arr[largest], arr[index]) ? largest : index;
            if (largest == index) {
                break;
            }
            exchange(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
}

// 求小和问题
class SmallSum{
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int result = 0;
        while (p1 <= mid && p2 <= r) {
            result += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return result;
    }
}