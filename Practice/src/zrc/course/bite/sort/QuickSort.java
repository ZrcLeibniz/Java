package zrc.course.bite.sort;

import java.util.Stack;

// 快速排序的递归写法
public class QuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, r, l + (int) (Math.random() * (r - l + 1)));
            int[] p = partition(arr, l, r);
            sort(arr, l, p[0] - 1);
            sort(arr, p[1] + 1, r);
        }
    }

    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }
}

// 快速排序的非递归写法
class QuickSortForLoop {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public void sort(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(l);
        stack.push(r);
        while (!stack.isEmpty()) {
            Integer right = stack.pop();
            Integer left = stack.pop();
            if (left >= right) {
                continue;
            }
            int[] partition = partition(arr, left, right);
            stack.push(right);
            stack.push(partition[1] + 1);
            stack.push(partition[0] - 1);
            stack.push(left);
        }
    }
}